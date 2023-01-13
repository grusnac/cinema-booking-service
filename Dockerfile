FROM openjdk:19-alpine

EXPOSE 8080

COPY ./target/cinema-booking-0.0.1-SNAPSHOT.jar cinema-booking.jar

CMD ["java", "-jar", "cinema-booking.jar"]