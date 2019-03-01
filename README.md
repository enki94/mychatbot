.\mvnw.cmd spring-boot:run
docker build -t mychatbot .
docker run -p 8080:8080 --link postgres:postgres solr:solr --name mychatbot mychatbot

