package pe.edu.cibertec.bookFlow.dto.book;

public record BookCreateDto(String title,
                            Integer authorId,
                            Integer typeBookGenreId,
                            Integer editorialId,
                            String publishedYear,
                            Boolean isAvailable) {
}
