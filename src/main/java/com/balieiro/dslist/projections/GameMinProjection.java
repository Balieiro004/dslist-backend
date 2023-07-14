package com.balieiro.dslist.projections;

public interface GameMinProjection {

    Long getId();
    String getTitle();
    Integer gameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();

}
