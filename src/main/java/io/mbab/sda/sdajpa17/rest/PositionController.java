package io.mbab.sda.sdajpa17.rest;

import io.mbab.sda.sdajpa17.entity.Position;
import io.mbab.sda.sdajpa17.repository.PositionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
class PositionController extends AbstractController<Position, Long> {

    private PositionRepository positionRepository;

    public PositionController(PositionRepository positionRepository) {
        super(positionRepository);
        this.positionRepository = positionRepository;
    }

    @GetMapping("/names")
    public List<String> findAllNames() {
        return positionRepository.findAllNames();
    }

    @GetMapping("/search")
    public List<Position> findByName(@RequestParam(required = false) String value) {
        return positionRepository.findByName(value);
    }
}
