package com.theta.playlistr.data.service.impl.sql;

import com.theta.playlistr.data.repository.WorkRepository;
import com.theta.playlistr.data.service.WorkDataService;
import com.theta.playlistr.domain.Work;
import org.springframework.stereotype.Service;

@Service
public class WorkDataServiceImpl extends AbstractDataServiceImpl<WorkRepository, Work> implements WorkDataService {
    public WorkDataServiceImpl(WorkRepository repository) {
        super(repository);
    }
}
