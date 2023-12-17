import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        //Coletando dados preenchidos pelo Cliente
        System.out.println("Digite a sua agência:");
        String ag = scanner.next();

        System.out.println("Digite a sua conta:");
        String cc = scanner.next();

        System.out.println("Digite sua senha:");
        String pass = scanner.next();

        File json = new File("Cliente.json");

        ObjectMapper obj = new ObjectMapper();

        Cliente cliente = new Cliente();

        List<Cliente> clienteList = obj.readValue(json, new TypeReference<List<Cliente>>(){});

        Optional<Cliente> objetoEncontrado = Optional.empty();
        for (Cliente objeto : clienteList) {
            if (objeto.getAgencia().equals(ag) && objeto.getConta().equals(cc) && objeto.getSenha().equals(pass)) {
                objetoEncontrado = Optional.of(objeto);
                break;
            }
        }

        Cliente resultado = objetoEncontrado.orElse(null);

        if (resultado != null) {
            System.out.println("Olá " + resultado.getNome());
            System.out.printf("Saldo disponível: R$ " + "%.2f", resultado.getSaldo());
        } else {
            System.out.println("Conta não encontrada ou a senha informada está incorreta");
        }


    }
}
