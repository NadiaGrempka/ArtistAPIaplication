package com.example.artistsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class MyRestService {

    private final ArtistRepository artistRepository;
    private final DepartmentRepository departmentRepository;
    private final TitleRepository titleRepository;
    private final DepartmentRepositoryJPA departmentJPA;
    private final ArtistRepositoryJPA artistRepositoryJPA;
    private final TitleRepositoryJPA titleRepositoryJPA;
    private Logger logger = Logger.getLogger("My Rest Service");

    private RestClient restClient;

    @Autowired
    public MyRestService(ArtistRepository artistRepository, DepartmentRepository departmentRepository, TitleRepository titleRepository, DepartmentRepositoryJPA departmentJPA, ArtistRepositoryJPA artistRepositoryJPA, TitleRepositoryJPA titleRepositoryJPA) {
        this.departmentJPA = departmentJPA;
        this.artistRepositoryJPA = artistRepositoryJPA;
        this.titleRepositoryJPA = titleRepositoryJPA;
        logger.info("Title Repository");
        this.titleRepository = titleRepository;
        logger.info("Department Repository");
        this.departmentRepository = departmentRepository;
        logger.info("Artists Repository");
        this.artistRepository = artistRepository;
        this.restClient = RestClient.create();
//        this.artistRepository.save(new Artist(1L, "pollock", "artist", "american", "painting", "male", "1921", "1954"));
//        this.artistRepository.save(new Artist(2L, "vincent", "artist", "dutch", "painting", "male", "1921", "1954"));
//        this.artistRepository.save(new Artist(3L, "pollock", "artist", "american", "painting", "male", "1921", "1954"));
//        this.artistRepository.save(new Artist(4L, "pollock", "artist", "american", "painting", "male", "1921", "1954"));
//        this.artistRepository.save(new Artist(5L, "pollock", "artist", "american", "painting", "male", "1921", "1954"));
    }

    public Optional<Artist> getArtistId(Long id){
        logger.info("Artist ID");
        return this.artistRepository.findById(id);
    }
    public List<Artist> getAllArtists(){
        logger.info("getAllArtists");
        return (List<Artist>) this.artistRepository.findAll();
    }

    public Optional<Department> getDepartmentId(Long id){
        logger.info("Get Department ID = " + id);
        return this.departmentRepository.findById(id);
    }
    public List<Department> getAllDepartments(){
        logger.info("getAllDepartments");
        return (List<Department>) this.departmentRepository.findAll();
    }

    // tu dodane
    public Department getDepartmentByName(String name) {
        return this.departmentRepository.findByDisplayName(name);
    }
    // to tez dodane
    public Department addNewDepartment(Department department) {
        return this.departmentRepository.save(department);
    }

    public List<Artist> getArtistByName(String name){
        return (List<Artist>) this.artistRepositoryJPA.findByName(name);
    }

    public Artist addNewArtist(Artist artist) {
        return this.artistRepository.save(artist);
    }

    public Optional<Title> getTitleId(Long id) {
        logger.info("Title ID");
        return this.titleRepository.findById(id);
    }

    public List<Title> getAllTitles() {
        logger.info("getAllTitles");
        return (List<Title>) this.titleRepository.findAll();
    }

    public List<Department> getDepartmentJPAByName(String name) {
        return (List<Department>) this.departmentJPA.findDepartmentByName(name);
    }

    public String getAllDepartmentsFromMET() {
        String departments = restClient
                .get()
                .uri("https://collectionapi.metmuseum.org/public/collection/v1/departments")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        return departments;
    }

    public List<Title> getTitle(String name) {
        logger.info("GetTitle = " + name);
        return (List<Title>) this.titleRepositoryJPA.findTitleByName(name);
    }

    public void deleteTitleById(Long id) {
        logger.info("deleteTile id="+id);
        this.titleRepository.deleteById(id);
    }

    public void deleteArtistById(Long id) {
        logger.info("deleteArtist id ="+id);
        this.artistRepository.deleteById(id);
    }

    public void deleteDepartmentById(Long id) {
        logger.info("deleteDepartment id="+id);
        this.departmentRepository.deleteById(id);
    }

    public void updateDepartment(Department department) {
        logger.info("updating department");
        this.departmentRepository.save(department);
    }

    public void updateArtist(Artist artist) {
        logger.info("updating artist");
        this.artistRepository.save(artist);
    }

    public void updateTitle(Title title) {
        logger.info("updating title");
        this.titleRepository.save(title);
    }

    public Title addNewTitle(Title title) {
        return this.titleRepository.save(title);
    }

//    public Optional<Title> getTitleId(Long id) {
//        logger.info("Title ID");
//        return this.titleRepository.findById(id);
//    }
//    public List<Title> getAllTitles() {
//        logger.info("getAllTitles");
//        return (List<Title>) this.titleRepository.findAll();
//    }

//    public Artist addNewCat(Artist kitty) {
//        System.out.println("Kot został zapisany");
//        return this.artistRepository.save(kitty);
//    }
//    public Artist updateCat(Artist upArtist){
//        return this.artistRepository.save(upArtist);
//    }
//    public void deleteCat(Artist delArtist){ this.artistRepository.delete(delArtist);}
//    public List<Artist> getAllCats(){
//        logger.info("getAllCats");
//        return (List<Artist>) this.artistRepository.findAll();
//    }
//    public List<Artist> filterByName(String search){
//        return getAllCats().stream().filter(artist -> artist.getName().contains(search)).toList();
//    }
//
//    public void deleteById(Long delById) {
//        this.artistRepository.deleteById(delById);
//    }
}
