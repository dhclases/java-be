
package com.dh.tecnico.runner;

import com.dh.tecnico.model.Jugador;
import com.dh.tecnico.model.Tecnico;
import com.dh.tecnico.repository.JugadorRepository;
import com.dh.tecnico.repository.TecnicoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(CommandLineRunnerImpl.class);

    private final TecnicoRepository tecnicoRepository;


    public CommandLineRunnerImpl(TecnicoRepository tecnicoRepository, JugadorRepository jugadorRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("*** Iniciando el proceso **** ");
        Jugador leoJugador;
        Tecnico tecnicoArg = Tecnico.builder()
                .nombre("Lionel Scaloni")
                .edad(44)
                .build();

        logger.info("*** Registrando  el Tecnico **** ");

        leoJugador = Jugador.builder()
                .nombre("Leonel Messi")
                .tecnico(tecnicoArg)
                .build();
        logger.info("*** Registrando el Jugador  **** ");

        Set<Jugador> jugadores = new HashSet<>();
        jugadores.add(leoJugador);

        tecnicoArg.setJugadores(jugadores);

        tecnicoRepository.save(tecnicoArg);

        logger.info("*** Buscando Tecnico  **** ");

        Optional<Tecnico> optTecnico = tecnicoRepository.buscarTecnico("Lionel Scaloni",55);

        optTecnico.ifPresent(tecnico -> logger.info("*** Tecnico encontrado {} ", tecnico.getNombre()));

        logger.info("*** Fin del proceso **** ");
    }
}

