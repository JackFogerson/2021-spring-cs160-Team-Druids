package com.example.parties;

import java.util.List;
import java.util.Optional;

@RestController
public class PartyController {

    @Autowired
    private PartyRepository userRepository;
        
    @GetMapping
    public List<Party> findAllUsers() {
        return PartyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Party> findUserById(@PathVariable(value = "id") long id) {
        Optional<Party> party = PartyRepository.findById(id);

        if(party.isPresent()) {
            return ResponseEntity.ok().body(party.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Party saveParty(@Validated @RequestBody Party party) {
        return PartyRepository.save(party);
    }
}