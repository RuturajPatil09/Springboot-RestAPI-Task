package com.task.ApiDesign.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.task.ApiDesign.Entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>
{

}
