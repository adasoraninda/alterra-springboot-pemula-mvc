package com.example.springmvc.repository;

import com.example.springmvc.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Perbedaan JpaRepository dan CrudRepository - package: jpa didapat dari package
 * org.springframework.data.jpa.repository.JpaRepository crud didapat dari package
 * org.springframework.data.repository.CrudRepository
 * <p>
 * - implementasi nya berbeda, jpa lebih banyak memiliki pilihan fungsi dibanding crud, dan
 * interface jpa juga extends ke PagingAndSortingRepository yang mana interface tersebut juga
 * extends ke CrudRepository
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
