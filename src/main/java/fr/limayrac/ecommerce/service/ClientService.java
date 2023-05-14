package fr.limayrac.ecommerce.service;

import fr.limayrac.ecommerce.model.Client;
import fr.limayrac.ecommerce.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<Client> getClientByUsername(String username) {
        return clientRepository.findByUsername(username);
    }

    public void createClient(String username, String password) {
        Optional<Client> existingClient = clientRepository.findByUsername(username);

        if (existingClient.isPresent()) {
            throw new IllegalStateException("Le nom d'utilisateur est déjà pris");
        }

        clientRepository.save(
                Client.builder()
                        .username(username)
                        .password(passwordEncoder.encode(password))
                .build());
    }
}
