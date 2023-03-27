package sg.edu.nus.iss.paf_day26_mongodb;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.paf_day26_mongodb.repositories.ShowsRepository;

@SpringBootApplication
public class PafDay26MongodbApplication implements CommandLineRunner {

	@Autowired
	private ShowsRepository showsRepo;

	public static void main(String[] args) {
		SpringApplication.run(PafDay26MongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// List<Document> results= showsRepo.findTvShowByName("Game of Thrones");
		// for(Document d : results){
		// 	System.out.printf(">> %s\n",d.toJson());
		// }
		
		// List<Document> results2= showsRepo.findShowTimeLessThan(30);
		// for(Document d : results2){
		// 	System.out.printf(">> %s\n",d.toJson());
		// }

		List<Document> results3= showsRepo.findMoviewByStatus("Ended");
		for(Document d : results3){
			System.out.printf(">> %s\n",d.toJson());
		}


	}

}
