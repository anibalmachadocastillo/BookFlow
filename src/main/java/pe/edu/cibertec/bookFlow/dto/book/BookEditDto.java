package pe.edu.cibertec.bookFlow.dto.book;

public record BookEditDto(Integer bookId,
                          String title,
                          Integer authorId,
                          Integer typeBookGenreId,
                          Integer editorialId,
                          String publishedYear,
                          Boolean isAvailable) {
}
