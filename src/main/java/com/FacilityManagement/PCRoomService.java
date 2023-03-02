package com.FacilityManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PCRoomService {

    @Autowired
    private PCRoomRepository repo;

    public List<PCRoom> listAll() {
        return repo.findAll();
    }

    public void save(PCRoom room) {
        repo.save(room);
    }

    public Room get(String mode) {
        return repo.findByDtype(mode); // findByDtype: the default method to find a sub-type
    }

    public void delete(String name) {
        repo.deleteByCourseid(name); // courseid - primary key in the Room table
    }
}
