package tn.esprit.kaddemspringbootproject.services;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.DetailEquipe;
import tn.esprit.kaddemspringbootproject.repositories.IDetailEquipeRepository;
import java.util.List;

@Service("DetailEquipeServices")
@RequiredArgsConstructor
public class DetailEquipeServices implements IDetailEquipeServices{
    @Autowired
    private final IDetailEquipeRepository detailEquipeRepository;

    @Override
    public List<DetailEquipe> retrieveAllDetailEquipe() {
        return detailEquipeRepository.retrieveAllDetailEquipe();
    }
    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }
    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }

    @Override
    public void removeDetailEquipe(Integer idDetailEquipe) {
        detailEquipeRepository.deleteById(idDetailEquipe);
    }
    @Override
    public DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe) {
        return detailEquipeRepository.findById(idDetailEquipe).get();
    }
    @Override
    public void removeAllDetailEquipe(){
        detailEquipeRepository.deleteAll();
    }

    @Override
    public DetailEquipe getDetailEquipeByEquipeId(Integer idEquipe) {
        return detailEquipeRepository.findByEquipe_IdEquipe(idEquipe);
    }
}
