package tn.esprit.firstproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Contrats;
import tn.esprit.firstproject.repositories.IContratsRepository;

import java.util.List;

@Service
public class ContratsService implements IContratsService{
    private final IContratsRepository cr;
    @Autowired
    public ContratsService(IContratsRepository cr) {
        this.cr = cr;
    }

    @Override
    public List<Contrats> retrieveAllContrats() {

        return cr.findAll();
    }

    @Override
    public Contrats updateContrat(Contrats ce) {

        return cr.save(ce) ;
    }

    @Override
    public Contrats addContrat(Contrats ce) {

        return cr.save(ce);
    }

    @Override
    public Contrats retrieveContrat(Integer idContrat) {

        return cr.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        cr.deleteById(idContrat);

    }
}
