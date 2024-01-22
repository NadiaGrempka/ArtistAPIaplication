package com.example.artistsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class MyRestContoller {

    private final MyRestService myRestService;
    //private final ExternalApiService externalApiService;
    private Logger logger = Logger.getLogger("My Rest Controller");
    @GetMapping("hello")
    public String hello(){
        return "Hello";
    }

    @Autowired
    public MyRestContoller(MyRestService myRestService) {
        this.myRestService = myRestService;
    }

    @GetMapping("artist/id/{id}")
    public Optional<Artist> findArtistId(@PathVariable("id") Long id){
        logger.info("find artist ID");
        return this.myRestService.getArtistId(id);
    }
    @GetMapping("artist/name/{name}")
    public List<Artist> findArtistByName(@PathVariable("name") String name){
        logger.info("find artist Name");
        return (List<Artist>) this.myRestService.getArtistByName(name);
    }
    @GetMapping("artist/viewAll")
    public List<Artist> viewAllArtists(){
        logger.info("viewAllArtists");
        return this.myRestService.getAllArtists();
    }
    @PostMapping("artist/add") //if it does not exist - create, if exist do nothing
    public Artist addNewArtist(@RequestBody Artist artist){
        Artist artistRet = new Artist();
//        System.out.println("Department" + department.getDisplayName());
        logger.info("Add new Artist");
        if (myRestService.getArtistByName(artist.getName())!=null){
//            System.out.println("Department already exists");
            logger.info("Artist already exists: " + artist.getName());
        }else {
            logger.info("Add new Artist before add");
            artistRet = myRestService.addNewArtist(artist);
            logger.info("Add new Artist after add");
        }
        return artistRet;
    }
    @DeleteMapping("artist/delete/{id}")
    public void deleteArtistById(@PathVariable("id") Long id){
        logger.info("DeleteArtistById przed usunieciem");
        if (!(myRestService.getArtistId(id).isEmpty())){
//            Title title = new Title();
//            title = myRestService.getTitleId(id).ifPresent();
            logger.info("jestesmy w if'ie");
            myRestService.deleteArtistById(id);
            //myRestService.deleteTitle(title);
        }
        logger.info("po usunieciu");
    }
    @PutMapping("artist/update") //if exist - update, if it does not exist, do nothing
    public Artist updateDepartment(@RequestBody Artist artist){
        logger.info("artist update przed ifem id = " + artist.getArtistId());
        if (!(myRestService.getArtistId(artist.getArtistId()).isEmpty())){
            logger.info("w if'ie, id="+artist.getArtistId());
            myRestService.updateArtist(artist);
        }
        logger.info("artist po if");
        return artist;
    }


    @GetMapping("department/id/{id}")
    public Optional<Department> findDepartmentId(@PathVariable("id") Long id){
        logger.info("find department ID");
        return this.myRestService.getDepartmentId(id);
    }
    @GetMapping("department/name/{name}")
    public List<Department> findDepartmentName(@PathVariable("name") String name){
        logger.info("find department Name");
        return (List<Department>) this.myRestService.getDepartmentJPAByName(name);
    }
    @GetMapping("department/viewAll")
    public List<Department> viewAllDepartments(){
        logger.info("viewAllDepartments");
        return this.myRestService.getAllDepartments();
    }
    @DeleteMapping("department/delete/{id}")
    public void deleteDepartmentById(@PathVariable("id") Long id){
        logger.info("DeleteDepartmentById przed usunieciem");
        if (!(myRestService.getDepartmentId(id).isEmpty())){
//            Title title = new Title();
//            title = myRestService.getTitleId(id).ifPresent();
            logger.info("jestesmy w if'ie");
            myRestService.deleteDepartmentById(id);
            //myRestService.deleteTitle(title);
        }
        logger.info("po usunieciu");
    }
    @PutMapping("department/update") //if exist - update, if it does not exist, do nothing
    public Department updateDepartment(@RequestBody Department department){
        logger.info("department update przed ifem id = " + department.getDepartmentId());
        if (!(myRestService.getDepartmentId(department.getDepartmentId()).isEmpty())){
            logger.info("w if'ie, id="+department.getDepartmentId());
            myRestService.updateDepartment(department);
        }
        logger.info("department po if");
        return department;
    }
    @PostMapping("department/add") //if it does not exist - create, if exist do nothing
    public Department addNewDepartment(@RequestBody Department department){
        Department departmentRet = new Department();
//        System.out.println("Department" + department.getDisplayName());
        if (myRestService.getDepartmentByName(department.getDisplayName())!=null){
//            System.out.println("Department already exists");
        }else {
            departmentRet = myRestService.addNewDepartment(department);
        }
        return departmentRet;
    }
    @GetMapping("department/fromMET")
    public String getAllDepartmentsFromMET(){
        logger.info("find department Name");
        return this.myRestService.getAllDepartmentsFromMET();
    }


    @GetMapping("title/id/{id}")
    public Optional<Title> findTitleId(@PathVariable("id") Long id){
        logger.info("find title ID");
        return this.myRestService.getTitleId(id);
    }
    @GetMapping("title/name/{name}")
    public List<Title> findTitleName(@PathVariable("name") String name){
        logger.info("find title name");
        return this.myRestService.getTitle(name);
    }
    @GetMapping("title/viewAll")
    public List<Title> viewAllTitles(){
        logger.info("viewAllTitles");
        return this.myRestService.getAllTitles();
    }
    @DeleteMapping("title/delete/{id}") // delete if exist
    public void deleteTitleById(@PathVariable("id") Long id){
        logger.info("DeleteTitleById przed usunieciem");
        if (!(myRestService.getTitleId(id).isEmpty())){
//            Title title = new Title();
//            title = myRestService.getTitleId(id).ifPresent();
            logger.info("jestesmy w if'ie");
            myRestService.deleteTitleById(id);
            //myRestService.deleteTitle(title);
        }
        logger.info("po usunieciu");
    }
    @PutMapping("title/update") //if exist - update, if it does not exist, do nothing
    public Title updateTitle(@RequestBody Title title){
        logger.info("title update przed ifem id = " + title.getTitleId());
        if (!(myRestService.getTitleId(title.getTitleId()).isEmpty())){
            logger.info("w if'ie, id="+title.getTitleId());
            myRestService.updateTitle(title);
        }
        logger.info("title po if");
        return title;
    }
    @PostMapping("title/add") //if it does not exist - create, if exist do nothing
    public Title addNewTitle(@RequestBody Title title){
        logger.info("Add new title, before if, title=" + title.getTitle());
        Title titleNew = new Title();
//        System.out.println("Department" + department.getDisplayName());
        if (myRestService.getTitle(title.getTitle()).isEmpty()){
            logger.info("title doesn't exist");
            titleNew = myRestService.addNewTitle(title);
        }
        return titleNew;
    }

}
