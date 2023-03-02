package com.FacilityManagement;

import jakarta.transaction.Transactional;

@Transactional
public interface ClassRoomRepository extends RoomBaseRepository<ClassRoom> { }

