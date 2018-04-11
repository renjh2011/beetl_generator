package com.huazi.generator.service.impl;

import com.huazi.generator.entity.SysLogEntity;
import com.huazi.generator.mappers.SysLogMapper;
import com.huazi.generator.service.SysLogService;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl implements SysLogService{

    @Autowired
    private SysLogMapper syslogmapper;
    @Override
    public List<SysLogEntity> get(SysLogEntity syslogentity) {
        return syslogmapper.get(syslogentity);
    }
}
