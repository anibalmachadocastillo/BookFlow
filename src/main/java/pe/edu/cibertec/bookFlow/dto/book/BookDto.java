package pe.edu.cibertec.bookFlow.dto;

public record BookDto(Integer bookId,
                      String title,
                      String author,
                      String editorial,
                      String publishedYear,
                      Boolean isAvailable) {
}
