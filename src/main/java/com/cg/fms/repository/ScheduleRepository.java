package com.cg.fms.repository;
import org.springframework.data.repository.CrudRepository;

import com.cg.fms.dto.Schedule;
public interface ScheduleRepository extends CrudRepository<Schedule,Integer>
{
}
