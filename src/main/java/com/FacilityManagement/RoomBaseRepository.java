package com.FacilityManagement;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RoomBaseRepository<T extends Room> extends JpaRepository<T, String> {

    public T findByDtype(String mode); // dtype - attribute in the Room table for ClassRoom or PCRoom

    public void deleteByCourseid(String courseid); // courseid - primary key in the Room table
}