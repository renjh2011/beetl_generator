package com.huazi.generator.mappers;
import java.util.*;
import com.huazi.generator.entity.SysLogEntity;
public interface SysLogMapper {
    List<SysLogEntity> get(SysLogEntity syslogentity);
    void insert(SysLogEntity syslogentity);
    void delete(SysLogEntity syslogentity);
    void update(SysLogEntity syslogentity);
}