package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer year;

    private Double rating;

    private Integer count;

    @ManyToOne
    @JoinColumn(name = "mpa_id")
    private Mpa mpa;

    @ManyToMany
    @JoinTable(name = "movies_genres",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")}
    )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(name = "actors_movies",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Actor> actors;

    @ManyToMany
    @JoinTable(name = "directors_movies",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "director_id")}
    )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Director> directors;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", count=" + count +
                ", mpa=" + mpa +
                '}';
    }
}
