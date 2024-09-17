package be.vdab.landen;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class LandService {
    private final LandRepository repository;

    LandService(LandRepository landRepository) {
        this.repository = landRepository;
    }

    public long findAantal(){
        return repository.count();
    }
}
