package persistence;

import java.util.List;

import org.dom4j.Node;

import Entity.Stock;

public class DatabaseHandler {
	private List<Node> storeName =null;
	private List<Node> quandlResponse =null;
	private HibernateConfiguration config = null;
	

	public DatabaseHandler(List<Node> storeList, List<Node> quandlResponse){
		this.storeName = storeList;
	     config = new HibernateConfiguration();
	}
	
	public List<Node> getStoreName() {
		return storeName;
	}


	public void setStoreName(List<Node> storeName) {
		this.storeName = storeName;
	}


	public List<Node> getQuandlResponse() {
		return quandlResponse;
	}


	public void setQuandlResponse(List<Node> quandlResponse) {
		this.quandlResponse = quandlResponse;
	}	
	public boolean initDataBase(){
		config.initHibernate();
		config.openSession();
		boolean isInit = false;
		if(checkIfStoreObjectAlreadyExist()){
			System.out.println("yes sbi exist");
		}else{
			createSchemas();
			System.out.println("no sbi donot exists");
			isInit = true;
			
		}
		config.shutDownSession();
		return isInit;
	}


	private void createSchemas() {
		// TODO Auto-generated method stub
		
	}

	private boolean checkIfStoreObjectAlreadyExist() {
		boolean exist = false;
		if(config.getSession().contains(Stock.class)){
			exist =true;
		}
		System.out.println("value of exists : " + exist);
		return exist;
	}


	

	public void fillStore() {
		// TODO Auto-generated method stub
		
	}
	// HibernateConfiguration config = new HibernateConfiguration();
	// config.initHibernate();
	//
	// config.getSession().beginTransaction();
	// for (Node node : quandlResponse) {
	// Node data = node.selectSingleNode("./dataset/data");
	// List<Node> stockDatumList=data.selectNodes("./datum");
	// for(Node stockDatum:stockDatumList){
	// // for each datum node
	// List<Node> datumDetailItems=stockDatum.selectNodes("./datum");
	// Stock stock=new
	// Stock(quandlResponse.get(0).selectSingleNode("./dataset/name").getStringValue(),
	// datumDetailItems.get(0).getStringValue(),
	// datumDetailItems.get(1).getStringValue(),
	// datumDetailItems.get(2).getStringValue(),
	// datumDetailItems.get(3).getStringValue(),
	// datumDetailItems.get(4).getStringValue(),
	// datumDetailItems.get(5).getStringValue(),
	// datumDetailItems.get(6).getStringValue(),
	// datumDetailItems.get(7).getStringValue());
	//
	// config.getSession().save(stock);
	//
	//
	// }
	// config.getSession().getTransaction().commit();
	// config.getFactory().close();
	
}
