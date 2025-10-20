FROM amazoncorretto:21-alpine3.19

WORKDIR /app

COPY /src/Main.java /src/SimpleLogger.java ./

RUN javac Main.java SimpleLogger.java

CMD ["java" , "Main"]


