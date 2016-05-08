package staLuzia.Sicaen.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import staLuzia.Sicaen.controllers.dialogs.AlertDialog;
import staLuzia.Sicaen.controllers.requiredFieldsFxml.ComboBoxFill;
import staLuzia.Sicaen.models.Encontrista;
import staLuzia.Sicaen.models.EncontristaRepositorio;
import staLuzia.Sicaen.models.dialogMessages.DialogMessage;

import java.io.*;
import java.net.URL;
import java.nio.Buffer;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Henrique on 06/05/2016.
 */
public class MainLayoutController implements Initializable{

    // VARIÁVEIS LOCAIS
    private List<TextInputControl> itensObrigatorios;
    private EncontristaRepositorio repositorio = null;
    private ComboBoxFill comboBoxFill;
    private String imagePerfilURL;
    private AlertDialog alertDialog;

    // VARIÁVEIS IDENTIFICADORES DO LAYOUT
    @FXML private ComboBox<String> pgtComboBox;
    @FXML private TextField nomeTextField;
    @FXML private TextField apelidoTextField;
    @FXML private ComboBox<String> relacionamentoComboBox;
    @FXML private DatePicker dtNascimentoDataPicker;
    @FXML private TextField celularTextField;
    @FXML private CheckBox whatsappCheck;
    @FXML private TextField whatsappTextField;
    @FXML private TextField responsavel1TextField;
    @FXML private TextField telefoneResp1TextField;
    @FXML private TextField responsavel2TextField;
    @FXML private TextField telefoneResp2TextField;
    @FXML private TextField emailTextField;
    @FXML private ComboBox<String> tamanhoCamisaComboBox;

    @FXML private ComboBox<String> religiaoComboBox;
    @FXML private TextField paroquiaTextField;
    @FXML private ComboBox<String> sacramentoComboBox;

    @FXML private TextField enderecoTextField;
    @FXML private TextField complementoTextField;
    @FXML private TextField cepTextField;
    @FXML private TextField bairroTextField;

    @FXML private CheckBox saudeSimCheckBox;
    @FXML private CheckBox saudeNaoCheckBox;
    @FXML private TextArea problemaSaudeTextArea;
    @FXML private CheckBox alimentarSimCheckBox;
    @FXML private CheckBox alimentarNaoCheckBox;
    @FXML private TextArea problemaAlimentarTextArea;

    // MÉTODOS DA CLASSE
    // Aqui você pode escrever os métodos que não estão diretamente
    // ligados ass chamadas da view
    public MainLayoutController(){
        this.comboBoxFill = new ComboBoxFill();
        this.alertDialog = new AlertDialog();
    }

    public void close(){
        if(this.repositorio != null){
            this.repositorio.close();
        }
    }

    //TODO
    public void inicializeComboBox(){
        //Incrição ComboBox
        //TODO

        //Relacionamento ComboBox
        this.relacionamentoComboBox.setItems(comboBoxFill.fillRelationshipComboBox());

        //Tamanho Camisa
        this.tamanhoCamisaComboBox.setItems(comboBoxFill.fillTshirSizeComboBox());

        //Religião ComboBox
        this.religiaoComboBox.setItems(comboBoxFill.fillReligionComboBox());

    }

    // Inicialização da View
    public void initialize(URL location, ResourceBundle resources) {
        inicializeComboBox();

    }

    public void moveFileToSicaenFilePath(File fileImage){
        try {
            File newImage = new File("imageProfile/"+fileImage.getName());
            OutputStream outputStream = new FileOutputStream(newImage);
            InputStream inputStream = new FileInputStream(fileImage);

            byte[] imageByteArray = new byte[(int)fileImage.length()];

            int length;

            while((length = inputStream.read(imageByteArray)) > 0){
                outputStream.write(imageByteArray, 0, length);
            }

            this.imagePerfilURL = (newImage.getParent()+"/"+newImage.getName());

        } catch (FileNotFoundException e) {
            //TODO lançar tela de erro
            System.out.println("Erro ao criar imagem");
            e.printStackTrace();
        } catch (IOException e) {
            //TODO lançar tela de erro
            System.out.println("Oh merda! Erro ao copiar imagem.");
            e.printStackTrace();
        }
    }

    // AÇÕES DA VIEW
    // Métodos onde a view os chamam diretamente, através de ações

    @FXML public void addEncontrista(){
        Encontrista encontrista = new Encontrista();

        encontrista.setNome(nomeTextField.getText());
        encontrista.setApelido(apelidoTextField.getText());
		/*encontrista.setRelacionamento(relacionamentoComboBox.getValue());
		encontrista.setDataNascimento(dtNascimentoDataPicker.getValue());
		encontrista.setCelular(celularTextField.getText());

		if(whatsappCheck.isSelected()){
			encontrista.setWhatsapp(whatsappTextField.getText());
		}else{
			encontrista.setWhatsapp(celularTextField.getText());
		}

		encontrista.setNomeResponsavel1(responsavel1TextField.getText());
		encontrista.setTelefoneResponsavel1(telefoneResp1TextField.getText());
		encontrista.setNomeResponsavel2(responsavel2TextField.getText());
		encontrista.setTelefoneResponsavel2(telefoneResp2TextField.getText());

		encontrista.setEmail(emailTextField.getText());
		encontrista.setTamanhoCamisa(tamanhoCamisaComboBox.getValue());

		if(saudeSimCheckBox.isSelected()){
			encontrista.setProblemaSaude(problemaSaudeTextArea.getText());
		}else{
			encontrista.setProblemaSaude(null);
		}

		if(alimentarSimCheckBox.isSelected()){
			encontrista.setProblemaAlimentar(problemaAlimentarTextArea.getText());
		}else{
			encontrista.setProblemaAlimentar(null);
		}

		encontrista.setEndereco(enderecoTextField.getText());
		encontrista.setComplemento(complementoTextField.getText());
		encontrista.setCep(cepTextField.getText());
		encontrista.setBairro(bairroTextField.getText());
		//encontrista.setReferencia();

		encontrista.setReligiao(religiaoComboBox.getValue());
		encontrista.setParoquia(paroquiaComboBox.getValue());
		encontrista.setSacramento(sacramentoComboBox.getValue());

		//encontrista.setImagemPerfil(imagemPerfil);
		*/
        encontrista.setImagemPerfil(this.imagePerfilURL);
        this.repositorio = new EncontristaRepositorio();
        this.repositorio.add(encontrista);
        alertDialog.showInformationDialog(DialogMessage.ADDED_SUCCESSFULLY_TITLE, DialogMessage.ADDED_SUCCESSFULLY_HEAD);
    }

    @FXML public void addProfileImage(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar imagem de perfil");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagens","*.jpg", "*.png", "*jpeg")
        );
        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            moveFileToSicaenFilePath(file);
        }
        System.out.println(this.imagePerfilURL);
    }
}
