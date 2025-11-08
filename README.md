# portfolio
Blog Website java Full Stack Developer
Portfolio single microservice (integrated frontend + backend)

How to run:
1. Import project into IntelliJ as a Maven project.
2. Run PortfolioFinalApplication (or: mvn spring-boot:run).
3. Open http://localhost:8080

Notes:
- Uses H2 in-memory DB by default so it runs without external DB.
- To use TiDB/MySQL, update src/main/resources/application.properties with your JDBC string.
