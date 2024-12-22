package pe.edu.cibertec.bookFlow.dto.book;

public record BookDto(Integer bookId,
                      String title,
                      String author,
                      String editorial,
                      String typeBookGenre,
                      String publishedYear,
                      Boolean isAvailable) {
}
