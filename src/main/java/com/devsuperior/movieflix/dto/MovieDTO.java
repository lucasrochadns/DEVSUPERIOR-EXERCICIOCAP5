package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class MovieDTO {

    @NotBlank
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String subTitle;
    @NotBlank
    private Integer year;
    @NotBlank
    private String imgUrl;
    @NotBlank
    private Long genreId;
    private List<ReviewDTO> review = new ArrayList<>();

    public MovieDTO(){}
    public MovieDTO(Long id, String title, String subTitle, Integer year, String imgUrl, Long genreId) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.year = year;
        this.imgUrl = imgUrl;
    }
    public MovieDTO(Movie entity, List<Review> reviews){
        this(entity);
        reviews.forEach(x -> this.review.add(new ReviewDTO(x)));

    }
    public MovieDTO(Movie entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.subTitle = entity.getSubTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.genreId= entity.getGenre().getId();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public List<ReviewDTO> getReview() {
        return review;
    }
}
