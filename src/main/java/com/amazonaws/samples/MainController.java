package com.amazonaws.samples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.AmazonEC2Exception;
import com.amazonaws.services.ec2.model.AuthorizeSecurityGroupIngressRequest;
import com.amazonaws.services.ec2.model.AuthorizeSecurityGroupIngressResult;
import com.amazonaws.services.ec2.model.CreateKeyPairRequest;
import com.amazonaws.services.ec2.model.CreateSecurityGroupRequest;
import com.amazonaws.services.ec2.model.CreateSecurityGroupResult;
import com.amazonaws.services.ec2.model.IpPermission;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


//메인 컨트롤러
public class MainController implements Initializable {
    //0.UI 
    @FXML
    private VBox MainManuTab;
    @FXML
    private VBox MainContentTab;
    
    //1.1.슈퍼매뉴 
    @FXML
    private Button SuperBtn1;
    @FXML
    private Button SuperBtn2;
    @FXML
    private Button SuperBtn3;
    
    //1.2.메인메뉴
    @FXML
    private Button SCBtn;
    @FXML
    private Button SGBtn;
    @FXML
    private Button ISBtn;
    @FXML
    private Button LEBtn;
    @FXML
    private Button LSBtn;
    @FXML
    private Button KPBtn;
    
    //2.0.텝 영역
    @FXML
    private TabPane MainContentTabPan;
    //2.1.탭
    @FXML
    private Tab SCTab;
    @FXML
    private Tab SGTab;
    @FXML
    private Tab ISTab;
    @FXML
    private Tab LETab;
    @FXML
    private Tab LSTab;
    @FXML
    private Tab CreateKeyTab;

    //3.컨트롤 매뉴
    @FXML
    private Button ResetBtn;
    @FXML
    private Button StartBtn;
    @FXML
    private Button ResetBucketBtn;


    //4.기능영역별 입출력 
    //4.1.SC
    @FXML
    private TextField SCSecurityKeyText;
    @FXML
    private TextField SCAccessKeyText;
    @FXML
    private ChoiceBox<String> ResionText;
    
    //4.2.SG
    @FXML
    private TextField SGDiscriptionText;
    @FXML
    private TextField SGGroupNameText;
    //4.3.IS
    @FXML
    private TextField ISIpText;
    @FXML
    private TextField ISFromPortText;
    @FXML
    private TextField ISGroupNameText;
    @FXML
    private TextField ISToPortText;
    @FXML
    private ComboBox<String> ISProtocolText;
    
    //4.4.0.LE 콤보
    @FXML
    private ComboBox<String> LEAmiIdComboBox;
    @FXML
    private ComboBox<String> LEInstanceTypeComboBox;
    
    //4.4.LE
    @FXML
    private TextField LEMaxCountText;
    @FXML
    private TextField LEKeyPairNameText;
    @FXML
    private TextField LEInstanceTypeText;
    @FXML
    private TextField LEAMDIdText;
    @FXML
    private TextField LEMinCountText;
    @FXML
    private TextField LESecurityGroupNameText;
    
    //4.6.LS
    @FXML
    private StackPane BucketListPan;
    
    //4.6.0.탭
    @FXML
    private Tab deleteBucketTab;
    @FXML
    private Tab UploadObjTab;
    @FXML
    private Tab OBJDownloadTab;
    
    //4.6.1.버킷추가
    @FXML
    private TextField CreateBucketText;
    @FXML
    private Label CreateBucketErrorText;
    @FXML
    private Button CreateBucketBtn;    
    
    //4.6.2.버킷삭제
    @FXML
    private Button DeleteBucketBtn;
    @FXML
    private TextField DeleteBucketText;

    
    //4.6.3.오브젝트 업로드
    @FXML
    private TextField UpChooseFileDirText;
    @FXML
    private TextField UpChooseBucketText;
    @FXML
    private Button UpChooseFileBtn;//파일선택 버튼
    @FXML
    private Button UploadFileBtn;//업로드 전송 버튼

    
    //4.6.4.오브젝트 다운로드 및 삭제
    @FXML
    private TextField DWDEBucketText;//버킷이름
    @FXML
    private TextField DWDEFileText;//오브젝트이름
    @FXML
    private Button DeleteFileBtn;
    @FXML
    private Button DownloadFileBtn;
    
    //4.7 키 생성
    @FXML
    private TextField KeyPairNameText;
    @FXML
    private Button KeyPairCreateBtn;

    
    private AmazonEC2 EC2Client = null;
    private AmazonS3 S3Client = null;
    
    private String AccessKey = "";
    private String SecretKey = "";
    
    private String GroupName = "";
    private String SGDiscription = "";
    
    private String IBIp = "";
    private String IBProtocol = "";
    private String IBGroupName = "";
    private int FromPort = 0;
    private int ToPort = 0;
    
    private int LaunchMaxcount = 0;
    private int LaunchMincount = 0;
    private String LaunchAMIId = "";
    private String LaunchInstanceType = "";
    private String LaunchSecurityGroup = "";
    private String LaunchKeyPair = "";
    /**
     * 프리티어 대상 인스턴스 목록
     * -작은 것도 포함
     */
    private Map<String,String> instanceMapList;
    
    /**
     * 프리티어 대상 AMI 목록
     */
    private Map<String,String> amiMapList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    MainManuControllBar();
	    contentControllerBar();
	    resetComBoBox();
	    s3Controll();
	    SCAccessKeyText.setText("AKIAJPPXN2ANAVMYQJ4A");
	    SCSecurityKeyText.setText("25TdoGxslSw344PqWUdIAaZqaRXO8Jxcg+VUYUnH");

	    //파일선택버튼
        UpChooseFileBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("sfsdfg");
                openSql((Stage)UpChooseFileBtn.getScene().getWindow());
            }
        });
        //파일업로드버튼
        /**
         * 오브젝트 업로드 전송 버튼
         */
          UploadFileBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
           	 //업로드 된 후 파일명
            	String dir = UpChooseFileDirText.getText();
                String objectName = "";
                String bucketName ="";
                int index=dir.lastIndexOf("\\");

                objectName = dir.substring(index+1);
                System.out.println("업로드 파일이름 : "+ objectName);
            
                //UpChooseFileDirText 업로드 할파일 위치
               
                bucketName =UpChooseBucketText.getText();
                if(objectName.equals("")||bucketName.equals("")){
                	EcreateAlert("파일 업로드 오류3","파라미터 부족");
                }else{
                    //UpChooseBucketText 버켓위치
                    try{
                        //파일 이름 중복되면 덮어쓰기
                        S3Client.putObject(new PutObjectRequest(bucketName, objectName, createSampleFile(dir)));
                        bucketListTree();
                        createAlert("업로드 완료",objectName+"가 업로드 되었습니다.");   
                    }catch(AmazonClientException ace){
                    	EcreateAlert("파일 업로드 오류1 : 클라이언트 오류",ace.getMessage());
                    } catch (IOException e) {
                    	EcreateAlert("파일 업로드 오류2 : 존재하지 않는 경우",e.getMessage());
        			}
                }
            }
         });
        
	}
	private File createSampleFile(String fileName) throws IOException {
        File file = null;
        file = new File(fileName);
        return file;
    }
	/**
	 * 클릭이벤트
	 * 1.슈퍼매뉴 
	 * 2.메인 매뉴
	 * 3.파일선택
	 */
	private void MainManuControllBar() {
	    //슈퍼매뉴
	     SuperBtn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent arg0) {
                createMenu(1);
            }
        });
	      SuperBtn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                createMenu(2);
            }
        });
	      SuperBtn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                createMenu(3);
            }
        });
	      
	    //메인매뉴 
        SCBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                moveTab(0);
            }
        });
        SGBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                moveTab(1);
            }
        });
        ISBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                moveTab(2);
            }
        });
        LEBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                moveTab(3);
            }
        });
        LSBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                moveTab(4);
            }
        });
        KPBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                moveTab(5);
            }
        });
    }
	/**
	 * 매인매뉴 생성
	 * -슈퍼매뉴 클릭 시 이벤트
	 */
	private void createMenu(int superMenuNum) {
      switch (superMenuNum) {
        case 1:
            hideMenu();
            hideTab();
            SCBtn.setVisible(true);//보이는 것
            SCBtn.setPrefWidth(150);
            SCBtn.setPrefHeight(90);
            SCTab.setDisable(false);//비활성화
            moveTab(0);
            break;
        case 2:
            hideMenu();
            hideTab();
            SGBtn.setVisible(true);//보이는 것
            ISBtn.setVisible(true);//보이는 것
            LEBtn.setVisible(true);//보이는 것
            KPBtn.setVisible(true);//보이는 것
            SGBtn.setPrefWidth(150);
            SGBtn.setPrefHeight(90);
            //System.out.println(SGBtn.getPadding());
            ISBtn.setPrefWidth(150);
            ISBtn.setPrefHeight(90);
            LEBtn.setPrefWidth(150);
            LEBtn.setPrefHeight(90);
            KPBtn.setPrefWidth(150);
            KPBtn.setPrefHeight(90);
            SGTab.setDisable(false);//비활성화
            ISTab.setDisable(false);//비활성화
            LETab.setDisable(false);//비활성화
            CreateKeyTab.setDisable(false);//비활성화
            moveTab(1);
            break;
        case 3:
            hideMenu();
            hideTab();
            LSBtn.setVisible(true);//보이는 것
            LSBtn.setPrefWidth(150);
            LSBtn.setPrefHeight(90);
            LSTab.setDisable(false);//비활성화
            moveTab(4);
            break;
        }
    }
	/**
	 * 매인매뉴 숨기기
	 */
	private void hideMenu() {
        SCBtn.setVisible(false);
        SGBtn.setVisible(false);
        ISBtn.setVisible(false);
        LEBtn.setVisible(false);
        LSBtn.setVisible(false);
        KPBtn.setVisible(false);
        SCBtn.setPrefWidth(0);
        SCBtn.setPrefHeight(0);
        SGBtn.setPrefWidth(0);
        SGBtn.setPrefHeight(0);
        ISBtn.setPrefWidth(0);
        ISBtn.setPrefHeight(0);
        LEBtn.setPrefWidth(0);
        LEBtn.setPrefHeight(0);
        LSBtn.setPrefWidth(0);
        LSBtn.setPrefHeight(0);
        KPBtn.setPrefWidth(0);
        KPBtn.setPrefHeight(0);
    }
	/**
	 * 탭 숨기기
	 */
	private void hideTab() {
	    //2.1.탭
	    SCTab.setDisable(true);
	    SGTab.setDisable(true);
	    ISTab.setDisable(true);
	    LETab.setDisable(true);
	    LSTab.setDisable(true);
	    CreateKeyTab.setDisable(true);
    }
	
    /**
	 * 탭 이동
	 */
	private void moveTab(int num) {
	    int tmp = -1;
	    switch (num) {
        case 0:tmp =0;
        ResetBucketBtn.setDisable(true);
            break;
        case 1:tmp =1;
        ResetBucketBtn.setDisable(true);
            break;
        case 2:tmp =2;
        ResetBucketBtn.setDisable(true);
        
            break;
        case 3:tmp =3;
        ResetBucketBtn.setDisable(true);
            break;
        case 4:tmp =4;
        ResetBucketBtn.setDisable(false);
            break;
        case 5:tmp =5;
        ResetBucketBtn.setDisable(true);
            break;
        }
	    if( tmp > -1 && tmp < 6 ){	        
	        MainContentTabPan.selectionModelProperty().get().select(tmp);
	        String tabName = selectedTabName();
	        resetText(tabName);
	    }
    }
	/**
	 * 3.컨트롤 매뉴
	 * - 확인/초기화/버킷목록 초기화
	 */
	private void contentControllerBar() {
	    ResetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String tabName = selectedTabName();
//                System.out.println("[이벤트]초기화"+tabName);
                resetText(tabName);
            }
        });
	    
	    StartBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String tabName = selectedTabName();
//                System.out.println("[이벤트]확인"+tabName);
                startAction(tabName);
            }
        });
	    
	    ResetBucketBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
//                System.out.println("[이벤트]버킷초기화");
                bucketListTree();
            }
        });
    }
    /**
	 * 선택된 탭의 이름
	 */
	private String selectedTabName() {
	    String selectedTabName = MainContentTabPan.selectionModelProperty().get().getSelectedItem().getText();
	    return selectedTabName;
    }

	/**
	 * 탭 선택시 데이터 입출력 초기화 
	 */
	private void resetText(String tabName) {
	    //System.out.println(tabName);
        switch (tabName) {
        case "Security Credential":
            SCAccessKeyText.clear();
            SCSecurityKeyText.clear();
            ResionText.getSelectionModel().clearSelection();
            break;
        case "Security Group":
            SGDiscriptionText.clear();
            SGGroupNameText.clear();
            break;
        case "Inbound Setting":
            ISIpText.clear();
            ISFromPortText.clear();
            ISGroupNameText.clear();
            ISToPortText.clear();
            ISProtocolText.getSelectionModel().select(1);
            ISProtocolText.getSelectionModel().select(0);
            break;
        case "Launch EC2":
            LaunchMaxcount=0;
            LaunchMincount=0;
            LEMinCountText.setText("0");
            LEMaxCountText.setText("0");
            LESecurityGroupNameText.clear();
            LEKeyPairNameText.clear();
            LEInstanceTypeComboBox.getSelectionModel().select(0);
            LEAmiIdComboBox.getSelectionModel().select(0);
            break;
        case "Launch S3":
            bucketListTree();
            break;            
        case "Key Pair생성":
            KeyPairNameText.clear();
            break;
        }
    }
    /**
     * 
     * 콤보박스, 초이스박스
     * 객체생성 후 리스너 생성메서드 호출
     */
    private void resetComBoBox() {
        ResionText.getItems().addAll("Asia Pacific(Seoul)","US West(N.California)","Us West(Oregon)");
        ISProtocolText.getItems().addAll("SSH","HTTP","HTTPS");
        //인스턴스 목록
        instanceMapList = new HashMap<>();
        instanceMapList.put("t2.micro", "t2.micro");
        Iterator<String> inimap= instanceMapList.keySet().iterator();
        while (inimap.hasNext()) {
            String key = inimap.next();
            LEInstanceTypeComboBox.getItems().add(key);            
        }
        
        //ami id 목록
        amiMapList =  new HashMap<>();
        amiMapList.put("SUSE Linux Enterprise Server 12 SP2 (HVM), SSD Volume Type", "ami-4b76a225");
        amiMapList.put("Ubuntu Server 16.04 LTS (HVM), SSD Volume Type", "ami-8fed39e1");
        amiMapList.put("Microsoft Windows Server 2016 Base", "ami-6a815604");
        amiMapList.put("Microsoft Windows Server 2016 Base with Containers", "ami-7c8e5912");
        amiMapList.put("Microsoft Windows Server 2016 Base Nano", "ami-6381560d");
        amiMapList.put("Microsoft Windows Server 2012 R2 Base", "ami-b08b5cde");
        amiMapList.put("Microsoft Windows Server 2012 Base", "ami-4c885f22");
        amiMapList.put("Microsoft Windows Server 2008 R2 Base ", "ami-c0984fae");
        amiMapList.put("Microsoft Windows Server 2008 Base/64", "ami-98984ff6");
        amiMapList.put("Microsoft Windows Server 2008 Base/32", "ami-cd8750a3");
        amiMapList.put("Microsoft Windows Server 2003 R2 Base/64", "ami-b89146d6 ");
        amiMapList.put("Microsoft Windows Server 2003 R2 Base/32", "ami-be9146d0");
        amiMapList.put("Ubuntu Server 14.04 LTS (HVM), SSD Volume Type", "ami-8ce236e2");
        amiMapList.put("직접입력", "");
        
        Iterator<String> amiMap= amiMapList.keySet().iterator();
        while (amiMap.hasNext()) {
            String key = amiMap.next();
            LEAmiIdComboBox.getItems().add(key);            
        }
        
        createAddListner();
    }
	/**
	 * 콘트롤박 - 	확인 동작
	 * 파리미터 탭이름
	 */
	  private void startAction(String tabName) {
		  boolean flag = true;
		  if(!tabName.equals("Security Credential")){
			  if(EC2Client == null){
				  flag = false;
			  }
		  }
		  if(flag){

	      switch (tabName) {
	        case "Security Credential":
	        	AccessKey=SCAccessKeyText.getText();
                SecretKey=SCSecurityKeyText.getText();
                 
                AWSCredentials credentials = new BasicAWSCredentials(AccessKey,SecretKey);
                
                EC2Client = new AmazonEC2Client(credentials);
                S3Client  = new AmazonS3Client(credentials);
                try{
                	//엑세스키 검사
                	S3Client.listBuckets();
  
	                Region region = null;
	                switch (ResionText.getSelectionModel().getSelectedIndex()) {
					case 0:
						region = Region.getRegion(Regions.AP_NORTHEAST_2);
						break;
					case 1:
						region = Region.getRegion(Regions.US_WEST_1);
						break;
					case 2:
						region = Region.getRegion(Regions.US_WEST_2);
						break;
					}
	                
	                EC2Client.setRegion(region);
//	                System.out.println();

	                createAlert("완료","증명되었습니다");
	                resetText("Security Credential");
                }catch(AmazonS3Exception ase){
                	 EC2Client = null;
                     S3Client  = null;
                	EcreateAlert("Key 불일치",ase.getMessage());
                }
                break;
	        case "Security Group":
	        	GroupName=SGGroupNameText.getText();
                SGDiscription=SGDiscriptionText.getText();
                CreateSecurityGroupRequest csgr = new CreateSecurityGroupRequest();
                csgr.withGroupName(GroupName).withDescription(SGDiscription);
                try {
                    CreateSecurityGroupResult createSecurityGroupResult=EC2Client.createSecurityGroup(csgr);
                    createAlert("완료", "Group ID : "+createSecurityGroupResult.getGroupId()+" 생성 되었습니다.");
                    resetText("Security Group");
                }catch (AmazonEC2Exception ase) {
                  EcreateAlert("오류 메시지",ase.getMessage());
                }
	            break;
	        case "Inbound Setting":
        	    IBIp=ISIpText.getText();
                IBProtocol= "TCP";
                IBGroupName=ISGroupNameText.getText();
                FromPort=Integer.parseInt(ISFromPortText.getText());
                ToPort= Integer.parseInt(ISToPortText.getText());
                
                IpPermission ipPermission = new IpPermission();
                ipPermission.withIpRanges(IBIp)
                            .withIpProtocol(IBProtocol)
                            .withFromPort(FromPort)
                            .withToPort(ToPort);
               
                AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest = new AuthorizeSecurityGroupIngressRequest();
                authorizeSecurityGroupIngressRequest.withGroupName(IBGroupName)
                                                    .withIpPermissions(ipPermission);
                
                try{
	                AuthorizeSecurityGroupIngressResult result=EC2Client.authorizeSecurityGroupIngress(authorizeSecurityGroupIngressRequest);
	                createAlert("Group Name : "+IBGroupName+"에 Inbound 설정되었습니다.","IP:"+IBIp+"\nProtocol : "+IBProtocol+"\nFromPort : "+FromPort+"\nToPort :"+ToPort);
	                resetText("Inbound Setting");
                }catch (AmazonEC2Exception ase) {
                	EcreateAlert("오류",ase.getMessage());
                }
	            break;
	        case "Launch EC2":
	        	LaunchMaxcount=Integer.parseInt(LEMaxCountText.getText());
                LaunchMincount=Integer.parseInt(LEMinCountText.getText());
                LaunchAMIId=LEAMDIdText.getText();
                LaunchInstanceType=LEInstanceTypeText.getText();
                LaunchSecurityGroup=LESecurityGroupNameText.getText();
                LaunchKeyPair=LEKeyPairNameText.getText();
                
                RunInstancesRequest runInstancesRequest = new RunInstancesRequest();
                runInstancesRequest.withImageId(LaunchAMIId)
                                   .withInstanceType(LaunchInstanceType)
                                   .withMinCount(LaunchMincount)
                                   .withMaxCount(LaunchMaxcount)
                                   .withKeyName(LaunchKeyPair)
                                   .withSecurityGroups(LaunchSecurityGroup);
                 try{
                       EC2Client.runInstances(runInstancesRequest);
                       createAlert("생성 완료", "EC2 Instacne 가 생성되었습니다.");
                       resetText("Launch EC2");
                 }catch (AmazonEC2Exception ase) {
                       EcreateAlert("오류",ase.getMessage());
                 }
	            break;
	        case "Launch S3":
	            resetText("Launch S3");
	            break;
	        case "Key Pair생성":
	        	CreateKeyPairRequest createKeyPairRequest = new CreateKeyPairRequest();
	    		createKeyPairRequest.withKeyName(KeyPairNameText.getText());
	    		//서버에 생성 요청
	    		try{ 	
	        		EC2Client.createKeyPair(createKeyPairRequest);
	        		createAlert("KeyPair 생성 완료", "KeyPair Name : "+createKeyPairRequest.getKeyName());
	        		resetText("Key Pair생성");
	    		}catch (AmazonEC2Exception ase) {
	        		//실패시 오류메시지 출력
	    			EcreateAlert("KeyPari 생성 실패", ase.getMessage());
	        	}
	            break;
	        }//switch
	  }else{
		  EcreateAlert("에세스 오류", "로그인 해주세요");
	  }//if
	  }
	  /**
	   * 버킷 트리 초기화
	   */
	  public void bucketListTree() {
	      if(S3Client == null){
	         
	      }else{
	          // rootItem 생성
	          TreeItem<String> root = new TreeItem<String>();
	          root.setExpanded(true);// treeview를 펼쳐보이게 설정 : Expanded 설정을 안하거나 false로 설정하면 접힌상태로 나타난다.
	          List<String> bucketList = listBucket();//버킷 목록 생성
	          for (int i = 0; i < bucketList.size(); i++) {
	              //1.버킷 아이템 생성
	              TreeItem<String> item = new TreeItem<String>(bucketList.get(i));
	              //item.setValue("B");
	              root.getChildren().add(item);
	              //2.버킷의 오브젝트 목록 생성
	              List<String> colList = listObject(bucketList.get(i));
	              for (int j = 0; j < colList.size(); j++) {
	                  //3.오브젝트 아이템 생성
	                  TreeItem<String> column = new TreeItem<String>(colList.get(j));
	                //  column.setValue("O");
	                  item.getChildren().add(column);
	              }
	          }
	         // treeview인스턴스생성
	          TreeView<String> treeview = new TreeView<String>(root);
	          treeview.setShowRoot(false);
	          BucketListPan.getChildren().clear();
	          BucketListPan.getChildren().add(treeview);
	          
	          treeview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {

                @Override
                public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue,
                        TreeItem<String> newValue) {
                    String itemName = newValue.getValue();
                    
                    if(newValue.getParent().getValue() == null){//부모 없는 아이템 : 버킷 
                        if(deleteBucketTab.isSelected()){                            
                            DeleteBucketText.setText(itemName);//버킷삭제 대상 버킷
                        }else if(UploadObjTab.isSelected()){
                            UpChooseBucketText.setText(itemName);//오브젝트 업로드 대상 버킷
                        }
                    }else {//오브젝트
                    	String tmp =  newValue.getParent().getValue();
                        if(OBJDownloadTab.isSelected()){
                            DWDEBucketText.setText(tmp);//오브젝트 다운로드 대상 버킷         
                            DWDEFileText.setText(itemName);//오브젝트 다운로드 대상 오브젝트
                        }                        
                    }
                }
              });
	      }
    }
	  
	 public List<String> listBucket(){
	      List<String> result = new ArrayList<>();
//          System.out.println("Listing buckets");
          for (Bucket bucket : S3Client.listBuckets()) {
              String bucketName = bucket.getName();
              result.add(bucketName);
//              System.out.println(" - " + bucketName);
          }
        return result;
      }
    public List<String> listObject(String bucketName){
        List<String> result = new ArrayList<>();
      if((S3Client.doesBucketExist(bucketName))){
          //System.out.println("Listing objects");
          ObjectListing objectListing = S3Client.listObjects(new ListObjectsRequest().withBucketName(bucketName));
          for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
              String objName = objectSummary.getKey();
//              System.out.println(" - objName = " + objName + ", " +
//                               "(objSize = " + objectSummary.getSize()/1024 + " KB )");
              result.add(objName);
          }
      }else{
          //System.out.println(bucketName+"");
      }
    return result;
  }
    /**
     * S3 메소드 모음
     */
  private void s3Controll() {
      /**
       * 버킷 생성
       */
      CreateBucketBtn.setOnAction(new EventHandler<ActionEvent>() {
        
        @Override
        public void handle(ActionEvent event) {
        	
        	String bucketName = CreateBucketText.getText();
            
            try{
               if(!(S3Client.doesBucketExist(bucketName))){
                    S3Client.createBucket(bucketName);   
                    bucketListTree();
                    createAlert("Bucket 생성완료", "Created bucket : " + bucketName);
               }
               else EcreateAlert("생성 실패",   bucketName+" 의 버킷 이름이 존재합니다. "); 
            }catch(AmazonClientException ace){
            	EcreateAlert("클라이언트 오류",   ace.getMessage());
            }
        }
    });
    /**
     * 버킷 삭제
     */
      DeleteBucketBtn.setOnAction(new EventHandler<ActionEvent>() {
        
        @Override
        public void handle(ActionEvent event) {
//        	삭제할 버킷 이름
            String bucketName = "";
            bucketName = DeleteBucketText.getText();
//            System.out.println("Deleting bucket " + bucketName + "\n");
            /*
             * 버킷안에 오브젝트 없어야 삭제 됨으로 오브젝트 전체 삭제후 버킷 삭제
             */
            if((S3Client.doesBucketExist(bucketName))){
//                System.out.println(" - removing objects from bucket");
                ObjectListing object_listing = S3Client.listObjects(bucketName);
                while (true) {
                    for (Iterator<?> iterator =
                            object_listing.getObjectSummaries().iterator();
                            iterator.hasNext();) {
                        S3ObjectSummary summary = (S3ObjectSummary)iterator.next();
                        S3Client.deleteObject(bucketName, summary.getKey());
                    }
                    // more object_listing to retrieve?
                    if (object_listing.isTruncated()) {
                        object_listing = S3Client.listNextBatchOfObjects(object_listing);
                    } else {
                        break;
                    }
                }
                S3Client.deleteBucket(bucketName);
                bucketListTree();
                createAlert("버킷 삭제 완료", bucketName+"버킷이 삭제되었습니다");
            }else
            {
            	EcreateAlert("오류", bucketName+" 버킷이 존재 하지 않습니다");
            }
        }
    });
    
    
     /**
      * 오브젝트 삭제
      */
     DeleteFileBtn.setOnAction(new EventHandler<ActionEvent>() {
        
        @Override
        public void handle(ActionEvent event) {
        //DWDEBucketText
    	 String bucketName = ""; 
    	 bucketName =DWDEBucketText.getText();
         //DWDEFileText
         String objectName = ""; 
         objectName =DWDEFileText.getText();

		  try{
		      if((S3Client.doesBucketExist(bucketName))){
		          if(S3Client.doesObjectExist(bucketName, objectName)){
		              S3Client.deleteObject(bucketName, objectName);
		              bucketListTree();
		              createAlert("오브젝트 삭제 완료", objectName+" (이)가 삭제 되었습니다");
		              DWDEBucketText.clear();
		              DWDEFileText.clear();
			  }else EcreateAlert("입력 오류(오브젝트)", objectName+"(이)가 존재 하지 않습니다");
			  }else EcreateAlert("입력 오류(버킷)", bucketName+"(이)가 존재 하지 않습니다");
		  }catch(AmazonClientException ace){
		  	EcreateAlert("클라이언트 오류", ace.getMessage());
		  }
        }
    });
     /**
      * 오브젝트 다운로드
      */
     DownloadFileBtn.setOnAction(new EventHandler<ActionEvent>() {
        
        @Override
        public void handle(ActionEvent event) {
        	String bucketName = "";
        	String objectName = "";
        	 File file = null;
        	 String dir = "C:/";
        	 bucketName =DWDEBucketText.getText();
        	//DWDEBucketText
             objectName =DWDEFileText.getText();
            //DWDEFileText
             
             if(bucketName.equals("")||bucketName == null||objectName.equals("")||objectName == null){
            	 EcreateAlert("파일다운로드오류0 : ", "파라미터 부족" );
             }else {
            	 try{
                     if((S3Client.doesObjectExist(bucketName, objectName))){
                    	 boolean flag = true;
                    	 while (flag) {
                             File file2 = null;
                    		 DirectoryChooser dirChooser = new DirectoryChooser();
                    		 dirChooser.setTitle("다운로드 경로지정하세요");
                    		 file2 = dirChooser.showDialog((Stage)DownloadFileBtn.getScene().getWindow());
                    		 dir = file2.getPath();
                    		//System.out.println(file2.getPath());
                    		//file2 = dirChooser.getInitialDirectory();
							if(file2.isFile()){
							   flag = false;
							}
						 }//while

                    	 String fileName = "";
                    	 fileName = objectName;
                         //경로 지정
                         file = new File(dir,fileName);
                    	 int count = 0;
                         //클라이언트로 부터 파일 받아옴
                         S3Object object = S3Client.getObject(new GetObjectRequest(bucketName, objectName));
                         InputStream in = object.getObjectContent();
                         byte[] buf = new byte[1024];
                         OutputStream out = new FileOutputStream(file);
                         
                         while( (count = in.read(buf)) != -1)
                         {
                            if( Thread.interrupted() )
                            {
                                throw new InterruptedException();
                            }
                            out.write(buf, 0, count);
                         }//while
                         out.close();
                         in.close();
                         
                         createAlert("다운로드 완료", dir+"위치에 파일이름 "+fileName+" 다운로드가 완료 되었습니다." );
                     }else{
                    	 EcreateAlert("입력 오류", bucketName+" 버킷에"+objectName+" 오브젝트가 없습니다." );
                     }//if
                 }catch (AmazonClientException ace){
                	 EcreateAlert("파일다운로드 오류1 :클라이언트 오류", ace.getMessage() );
                        
                 } catch (IOException e) {
                	 EcreateAlert("파일다운로드 오류2 : 파일 생성 오류", e.getMessage() );
    				
    			 } catch (InterruptedException e) {
					 //e.printStackTrace();
					 EcreateAlert("파일다운로드 오류3  : 파일 생성 오류", e.getMessage() );
				 }
            }//if
        }
    });
   }
  /**
   * 알람 발생
   */
  private void createAlert(String cont1,String cont2) {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("AWS Management console");
	    alert.setHeaderText(cont1);
	    alert.setContentText(cont2);
	    alert.show();
  }
  private void EcreateAlert(String cont1,String cont2) {
		    Alert alert = new Alert(AlertType.ERROR);
		    alert.setTitle("AWS Management console");
		    alert.setHeaderText(cont1);
		    alert.setContentText(cont2);
		    alert.show();
  }
  /**
   * 파일오픈
   */
    private void openSql(Stage primaryStage) {
 	      // 0.1.입력할 파일 선택
          String fileDir ="";
 	      Alert alert = new Alert(AlertType.INFORMATION);
 	      FileChooser fc = new FileChooser();
 	      FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
 	            "데이터 베이스 파일", "*.sql");
 	      FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter(
 	            "텍스트 파일", "*.TXT");
 	      FileChooser.ExtensionFilter extFilter3 = new FileChooser.ExtensionFilter(
  	            "이미지 파일", "*.JPG");
 	      fc.getExtensionFilters().add(extFilter3);
 	      fc.getExtensionFilters().add(extFilter2);
 	      fc.getExtensionFilters().add(extFilter);
 	      fc.setInitialDirectory(new File("C:/"));
 	      File file = fc.showOpenDialog(primaryStage);// 화면출력 사용자 정보입력 받고 다음실행

 	      // 0.3 내용
 	      try {
 	         // 파일이름
// 	         String sqlTitle = file.getName();
 	         // 파일경로
// 	         String path = file.getAbsolutePath();
 	         fileDir = file.getPath();
// 	         System.out.println("파일 전체경로 : " + fileDir);
// 	         System.out.println("제목 : "+sqlTitle + ", 경로 : "+ path + ", 내용 : "+ sb);
 	      } catch (Exception ex) {
 	         alert.setTitle("Information Dialog");
 	         alert.setHeaderText(null);
 	         alert.setContentText("취소되었습니다.");
 	         alert.showAndWait();
 	      } finally {
 	         UpChooseFileDirText.setText(fileDir);
        }
 	   }
    /**
     * 리스너 모음
     * -프로토콜 : 포트 
     * -인스턴스타입 : 
     * -AMI ID    : 
     */
    private void createAddListner() {
        //프로토콜 선택
        ISProtocolText.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String tmp = newValue;
                String port = "";
                boolean flag = true;
                switch (tmp) {               
                    case "SSH":
                        port = "22";
                    break;
                    case "HTTP":
                        port = "80";
                    break;
                    case "HTTPS":
                        port = "443";
                    break;
                    default :
                        flag = false;
                    break;
                }
                if(flag){
                    ISFromPortText.setText(port);
                    ISToPortText.setText(port);
                }
            }
        });
        //LE 인스턴스 타입
        LEInstanceTypeComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String tmp = newValue;
                //System.out.println(tmp);
                LEInstanceTypeText.setText(tmp);
            }
        });
        //LE AMI ID LEInstanceTypeText.setText("");
        LEAmiIdComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String tmp = newValue;
                //System.out.println(tmp);
                if(tmp.equals("직접입력")){
                    LEAMDIdText.setEditable(true);
                    LEAMDIdText.setText("");
                }else {
                    String val = amiMapList.get(tmp);
                    LEAMDIdText.setText(val);
                    LEAMDIdText.setEditable(false);
                }
            }
        });
    }
}