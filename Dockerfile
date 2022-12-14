FROM openjdk:19-alpine

EXPOSE 8080

ENV SPRING_DATASOURCE_URL="jdbc:postgresql://postgres:5432/cinema_booking_system"
ENV SPRING_DATASOURCE_USERNAME="clerk"
ENV SPRING_DATASOURCE_PASSWORD="king-in-the-castle"
ENV SPRING_JPA_HIBERNATE_DDL_AUTO="validate"
ENV SPRING_JPA_OPEN_IN_VIEW="false"
ENV LOGGER_LEVEL_ROOT="false"

COPY ./target/cinema-booking-0.0.1-SNAPSHOT.jar cinema-booking-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "cinema-booking-0.0.1-SNAPSHOT.jar"]