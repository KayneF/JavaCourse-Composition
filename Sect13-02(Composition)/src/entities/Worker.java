package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	/**
	 * O atributo 'departament' está relacionado de forma
	 * "1-1", então nesse caso, relacionamos apenas 1
	 * como de costume.
	 */
	private Department department;
	/**
	 * O atributo 'contracts' está relacionado de forma
	 * "1-N", e como poderão ser relacionados multiplos
	 * contratos, então criaremos uma lista desse objeto
	 * como atributo.
	 */
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public Double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<HourContract> getContracts() {
		return contracts;
	}
	
	
	/**
	 * O atributo 'lista', terá seus próprios métodos para
	 * adicionar ou remover items da lista. Como que de nenhuma
	 * forma essa lista deverá ser alterada, o método setter do 
	 * atributo 'contracts' não estará presente na da classe.
	 */
	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}
	public void removeContract(HourContract contract) {
		this.contracts.remove(contract);
	}
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
