package com.FacilityManagement;

import jakarta.transaction.Transactional;

@Transactional
public interface PCRoomRepository extends RoomBaseRepository<PCRoom> {
}
