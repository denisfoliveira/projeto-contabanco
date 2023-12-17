import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AberturaConta {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Seja bem vindo ao banco CloudBank!");
        System.out.println("Digite 1 para Abrir uma conta ou 2 para Consultar seu Saldo");
        int numeroDigitado = scanner.nextInt();

        if (numeroDigitado == 1) {
            AberturaConta p = new AberturaConta();
            p.Abertura();
        } else {
            AberturaConta p = new AberturaConta();
            p.Consulta();
        }

    }
    public void Abertura () throws IOException {
        String agencia = "1211";
        int min = 1000;
        int max = 9999;

        int conta_random = (int)(Math.random() * (max - min + 1) +min);

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);;

        System.out.println("Digite o seu Nome");
        String nome = scanner.nextLine();

        System.out.println("Digite uma senha de 4 números:");
        String senha = scanner.next();

        System.out.println("Insira o valor do seu primeiro Depósito:");
        double deposito = scanner.nextDouble();

        Cliente cliente1 = new Cliente();
        cliente1.setNome(nome);
        cliente1.setSenha(senha);
        cliente1.setSaldo(deposito);
        cliente1.setAgencia(agencia);
        cliente1.setConta(String.valueOf(conta_random));

        Cliente cliente2 = new Cliente();

        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(cliente1);
        clientes.add(cliente2);

        String jsonCliente = new Gson().toJson(clientes);

        FileWriter fileWriter = new FileWriter("Cliente.json");

        fileWriter.write(jsonCliente);
        fileWriter.flush();
        fileWriter.close();
        System.out.println("Seja bem vindo ao CloudBank, " + nome + ". Sua Conta Corrente foi aberta com sucesso.");
        System.out.println("Agencia: "+ agencia + " Conta Corrente: " + conta_random);
        System.out.printf("Saldo disponível: R$ " + "%.2f", deposito);

    }
    public void Consulta () throws IOException {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite a sua agência:");
        String ag = scanner.next();

        System.out.println("Digite a sua conta:");
        String cc = scanner.next();

        System.out.println("Digite sua senha:");
        String pass = scanner.next();

        File json = new File("Cliente.json");

        ObjectMapper obj = new ObjectMapper();

        List<Cliente> clienteList = obj.readValue(json, new TypeReference<List<Cliente>>(){});

        Optional<Cliente> objetoEncontrado = Optional.empty();
        for (Cliente objeto : clienteList) {
            if (objeto.getAgencia() != null && objeto.getConta() != null && objeto.getSenha() != null &&
                    objeto.getAgencia().equals(ag) && objeto.getConta().equals(cc) && objeto.getSenha().equals(pass)) {
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
