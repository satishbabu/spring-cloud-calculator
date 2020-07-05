# Zipkin Server
Good talk on Zipkin by Adrian Cole (@adrianfcole) https://www.youtube.com/watch?v=f9J1Av8rwCE.  Advice is start small, fail fast avoid using plugins that you dont need/know.

Downloading zipkin is tricky.  Latest Zipkin standalone server jar can be downloaded from maven using URL https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec.  

Launch 'java -jar zipkin-server-xxx.jar'.  Visit http://localhost:9411/zipkin/ to see zipkin dashboard.  The spring.application.name has to be set correctly for sleuth to write into logs.

Zipkin has pluggable architecture.  The logs can be sent over RabbitMQ or Kafka or HTTP or several other options.  I am using HTTP in this instance as it is simple (default option for writing writing logs to zipkin from spring boot).  Logs can be stored in either mysql, cassandra, in-memory or several other options.  I am using in-memory (by default) as it is simple to set it up.