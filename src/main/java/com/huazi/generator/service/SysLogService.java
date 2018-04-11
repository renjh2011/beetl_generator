package com.huazi.generator.service;

import com.huazi.generator.entity.SysLogEntity;
import com.huazi.generator.mappers.SysLogMapper;
import com.huazi.generator.service.SysLogService;
import java.util.*;

public interface SysLogService {
    List<SysLogEntity> get(SysLogEntity syslogentity);
}
