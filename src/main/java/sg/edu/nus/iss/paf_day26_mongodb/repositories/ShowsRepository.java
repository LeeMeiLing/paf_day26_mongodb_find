package sg.edu.nus.iss.paf_day26_mongodb.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ShowsRepository {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public static final String C_TVSHOWS = "tvshows";

    // write Native Mongo Query here in assessment !!!
    // db.tvshows.find({name:'the name'})
    public List<Document> findTvShowByName(String title){

        // Create the filter - the Criteria
        // {name: 'the name'}
        Criteria criteria = Criteria.where("name").is(title);

        // Create the query
        Query query = Query.query(criteria);

        // Execute the query
            // List<Document> results = mongoTemplate.find(query,Document.class,"tvshows");
            // return results;
        return mongoTemplate.find(query,Document.class,C_TVSHOWS);

    }

    /*
     * db.tvshows.find({
     *  {"rating.average": {$gte:6.5}},
     * {"runtime": {$lte:30}}
     * })
     */
    public List<Document> findShowTimeLessThan(int mins){

        Criteria criteria = Criteria.where("rating.average").gte(6.5)
            .andOperator(Criteria.where("runtime").lte(mins));

        Query query = Query.query(criteria);
        
        return mongoTemplate.find(query, Document.class,C_TVSHOWS);
 
    }

     /*
     * db.tvshows
        *  .find({status: "Ended"})
        *  .sort({ "rating.average" : -1, name : 1 })
     */
    public List<Document> findMoviewByStatus(String status){

        Criteria criteria = Criteria.where(status).is(status);

        Query query = Query.query(criteria)
            .with(
                Sort.by(Direction.DESC, "rating.average")
                    .by(Direction.ASC,"name")
            );
        
        return mongoTemplate.find(query, Document.class,C_TVSHOWS);
 
    }
}
