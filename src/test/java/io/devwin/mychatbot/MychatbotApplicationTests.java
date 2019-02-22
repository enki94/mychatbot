package io.devwin.mychatbot;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.devwin.mychatbot.model.Posts;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MychatbotApplicationTests {

    @Autowired
    PostsRepository postsRepository;	
    
    @After
    public void cleanup() {
        //postsRepository.deleteAll();
    }    
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void 솔라테스트() {
		String url = "http://localhost:8983/solr/gettingstarted";
		try {
			HttpSolrClient solr = new HttpSolrClient.Builder(url).build();
			solr.setParser(new XMLResponseParser());
			SolrQuery query = new SolrQuery();
			query.set("q", "*:*");
			QueryResponse res = solr.query(query);
			SolrDocumentList doc = res.getResults();
			System.out.println("솔라결과:");
			System.out.println(doc.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void JPA테스트() {
		Posts p = new Posts();
		p.setTitle("게시판 제목");
		p.setContent("게시판 본문");
		p.setAuthor("enki@devwin.io");
		postsRepository.save(p);
		
		List<Posts> list = postsRepository.findAll();
		System.out.println("JPA결과:");
		for(Posts p1:list){
			System.out.println(p1.toString());
		}
	}

}
