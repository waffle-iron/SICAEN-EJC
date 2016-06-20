package staLuzia.Sicaen.controllers;

import com.itextpdf.text.DocumentException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import staLuzia.Sicaen.controllers.dialogs.AlertDialog;
import staLuzia.Sicaen.controllers.requiredFieldsFxml.ComboBoxFill;
import staLuzia.Sicaen.models.encontrista.Encontrista;
import staLuzia.Sicaen.models.encontrista.EncontristaRepositorio;
import staLuzia.Sicaen.models.dialogMessages.DialogMessage;
import staLuzia.Sicaen.models.pdf.PDFReport;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Henrique on 06/05/2016.
 */
public class MainLayoutController implements Initializable{

    // VARIÁVEIS LOCAIS
    private List<TextInputControl> itensObrigatorios;
    private static EncontristaRepositorio repositorio;
    private String imagePerfilURL;

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

    @FXML private ImageView profileImageView;

    // MÉTODOS DA CLASSE
    // Aqui você pode escrever os métodos que não estão diretamente
    // ligados ass chamadas da view
    public MainLayoutController(){
    }

    public static void close(){
        if(repositorio != null){
            repositorio.close();
        }
    }

    public void inicializeComboBox(){
        //Relacionamento ComboBox
        this.relacionamentoComboBox.setItems(ComboBoxFill.fillRelationshipComboBox());

        //Tamanho Camisa
        this.tamanhoCamisaComboBox.setItems(ComboBoxFill.fillTshirSizeComboBox());

        //Religião ComboBox
        this.religiaoComboBox.setItems(ComboBoxFill.fillReligionComboBox());

        //Pagamento
        this.pgtComboBox.setItems(ComboBoxFill.fillPaymentComboBox());
    }

    // Inicialização da View
    public void initialize(URL location, ResourceBundle resources) {
        inicializeComboBox();

    }

    private void moveFileToSicaenFilePath(File fileImage){
        try {
            File newImage = new File("imageProfile/"+fileImage.getName());
            OutputStream outputStream = new FileOutputStream(newImage);
            InputStream inputStream = new FileInputStream(fileImage);

            byte[] imageByteArray = new byte[(int)fileImage.length()];

            int length;

            while((length = inputStream.read(imageByteArray)) > 0){
                outputStream.write(imageByteArray, 0, length);
            }

            this.imagePerfilURL = (newImage.getAbsolutePath());

        } catch (FileNotFoundException e) {
            //TODO lançar tela de erro
            AlertDialog.showExceptionDialog(DialogMessage.ERROR_EXCEPTION_TITLE, DialogMessage.ERROR_EXCEPTION_HEAD, e);
            e.printStackTrace();
        } catch (IOException e) {
            //TODO lançar tela de erro
            AlertDialog.showExceptionDialog(DialogMessage.ERROR_EXCEPTION_TITLE, DialogMessage.ERROR_EXCEPTION_HEAD, e);
            e.printStackTrace();
        }
    }

    private void clearFields(){
        this.nomeTextField.setText("");
        this.apelidoTextField.setText("");
        this.celularTextField.setText("");
        this.whatsappCheck.setSelected(false);
        this.whatsappTextField.setText("");
        this.responsavel1TextField.setText("");
        this.telefoneResp1TextField.setText("");
        this.responsavel2TextField.setText("");
        this.telefoneResp2TextField.setText("");
        this.emailTextField.setText("");
        this.paroquiaTextField.setText("");
        this.enderecoTextField.setText("");
        this.cepTextField.setText("");
        this.complementoTextField.setText("");
        this.bairroTextField.setText("");
        this.problemaSaudeTextArea.setText("");
        this.problemaAlimentarTextArea.setText("");
        this.pgtComboBox.setValue("Selecione");
        this.relacionamentoComboBox.setValue("Selecione");
        this.tamanhoCamisaComboBox.setValue("Selecione");
        this.religiaoComboBox.setValue("Selecione");
        this.sacramentoComboBox.setValue("Selecione");
    }

    // AÇÕES DA VIEW
    // Métodos onde a view os chamam diretamente, através de ações

    @FXML public void addEncontrista(){
        Encontrista encontrista = new Encontrista();

        encontrista.setNome(nomeTextField.getText());
        encontrista.setApelido(apelidoTextField.getText());
		encontrista.setRelacionamento(relacionamentoComboBox.getValue());
		encontrista.setDataNascimento(String.valueOf(dtNascimentoDataPicker.getValue()));
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
		encontrista.setParoquia(paroquiaTextField.getText());
		encontrista.setSacramento(sacramentoComboBox.getValue());

        encontrista.setImagemPerfil(this.imagePerfilURL);

        this.repositorio = new EncontristaRepositorio();
        this.repositorio.add(encontrista);
        AlertDialog.showInformationDialog(DialogMessage.ADDED_SUCCESSFULLY_TITLE, DialogMessage.ADDED_SUCCESSFULLY_HEAD);
        clearFields(); // Limpa todos os campos após acadastro
        PDFReport pdfReport = new PDFReport();
        pdfReport.generateEncontristaPDFReport(this.repositorio.list());

    }

    @FXML public void openChooserDialog(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar imagem de perfil");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagens","*.jpg", "*.png", "*jpeg")
        );
        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            Image image = new Image(file.toURI().toString());
            this.profileImageView.setImage(image);
            moveFileToSicaenFilePath(file);
        }
    }

    @FXML public void setSaudeSimCheckBox(){
        if(saudeNaoCheckBox.isSelected()){
            saudeNaoCheckBox.setSelected(false);
        }else{
            saudeSimCheckBox.setSelected(true);
        }

        problemaSaudeTextArea.setEditable(true);
    }

    @FXML public void setSaudeNaoCheckBox(){
        if(saudeSimCheckBox.isSelected()){
            saudeSimCheckBox.setSelected(false);
        }else{
            saudeNaoCheckBox.setSelected(true);
        }
        problemaSaudeTextArea.setText("");
        problemaSaudeTextArea.setEditable(false);
    }

    @FXML public void setAlimentarSimCheckBox(){
        if(alimentarNaoCheckBox.isSelected()){
            alimentarNaoCheckBox.setSelected(false);
        }else{
            alimentarSimCheckBox.setSelected(true);
        }
        problemaAlimentarTextArea.setEditable(true);
    }

    @FXML public void setAlimentarNaoCheckBox(){
        if(alimentarSimCheckBox.isSelected()){
            alimentarSimCheckBox.setSelected(false);
        }else{
            alimentarNaoCheckBox.setSelected(true);
        }
        problemaAlimentarTextArea.setText("");
        problemaAlimentarTextArea.setEditable(false);
    }
}
