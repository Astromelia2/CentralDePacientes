/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�as de la Informaci�n y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de cl�nicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de cl�nicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Cl�nica del Country");
        listaClinicas.add("Cl�nica Palermo");
        listaClinicas.add("Cl�nica Reina Sof�a");
        listaClinicas.add("Cl�nica El Bosque");
        listaClinicas.add("Cl�nica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de pacientes de la cl�nica
     *
     * @return El n�mero de pacientes de la cl�nica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        pacientes.add(0, pac); // Agrega el paciente al comienzo de la lista
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        pacientes.add(pac);
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente despu�s del paciente con el c�digo dado
        // Buscar el índice del paciente con el código dado
        int indice = -1;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                indice = i;
                break;
            }
        }

        // Verificar si se encontró el paciente
        if (indice == -1) {
            throw new NoExisteException(cod);
        }

        // Agregar el nuevo paciente antes del paciente con el código dado
        pacientes.add(indice, pac);
    }

    /**
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente despu�s del paciente con el c�digo cod
        // Buscar el índice del paciente con el código dado
        int indice = -1;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                indice = i;
                break;
            }
        }

        // Verificar si se encontró el paciente
        if (indice == -1) {
            throw new NoExisteException(cod);
        }

        // Agregar el nuevo paciente después del paciente con el código dado
        // Se suma 1 al índice para insertar después del paciente encontrado
        pacientes.add(indice + 1, pac);
    }

    /**
     * Busca el paciente con el c�digo dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        // Recorrer la lista de pacientes
        for (Paciente paciente : pacientes) {
            // Verificar si el paciente tiene el código buscado
            if (paciente.darCodigo() == codigo) {
                return paciente; // Devolver el paciente encontrado
            }
        }
        return null; // Devolver null si no se encontró el paciente
    }

    /**
     * Elimina el paciente con el c�digo especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // Buscar el índice del paciente con el código dado
        int indice = -1;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                indice = i;
                break;
            }
        }

        // Verificar si se encontró el paciente
        if (indice == -1) {
            throw new NoExisteException(cod);
        }

        // Eliminar el paciente de la lista
        pacientes.remove(indice);

    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de cl�nicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        int contadorHombres = 0;
        // Recorrer la lista de pacientes
        for (Paciente paciente : pacientes) {
            // Verificar si el paciente es hombre
            if (paciente.darSexo() == Paciente.HOMBRE) {
                contadorHombres++;
            }
        }
        return contadorHombres; // Devolver la cantidad de hombres
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        int contadorMujeres = 0;
        // Recorrer la lista de pacientes
        for (Paciente paciente : pacientes) {
            // Verificar si el paciente es mujer
            if (paciente.darSexo() == Paciente.MUJER) {
                contadorMujeres++;
            }
        }
        return contadorMujeres; // Devolver la cantidad de mujeres
    }

    /**
     * De las 6 opciones de cl�nicas que tiene la central
     * �Cu�l es el nombre de la m�s ocupada, la que tiene m�s pacientes?
     *
     * @return nombre de la cl�nica
     */
    public String metodo4() {
        // Crear un mapa para contar el número de pacientes en cada clínica
        Map<String, Integer> contadorClinicas = new HashMap<>();
        for (String clinica : listaClinicas) {
            contadorClinicas.put(clinica, 0);
        }

        // Recorrer la lista de pacientes y aumentar el contador correspondiente a la clínica de cada paciente
        for (Paciente paciente : pacientes) {
            String clinicaPaciente = paciente.darClinica();
            contadorClinicas.put(clinicaPaciente, contadorClinicas.get(clinicaPaciente) + 1);
        }

        // Encontrar la clínica con el mayor número de pacientes
        String clinicaMasOcupada = null;
        int maxPacientes = 0;
        for (Map.Entry<String, Integer> entrada : contadorClinicas.entrySet()) {
            if (entrada.getValue() > maxPacientes) {
                maxPacientes = entrada.getValue();
                clinicaMasOcupada = entrada.getKey();
            }
        }

        return clinicaMasOcupada;
    }
}
