class Employee {
    id :number;
    name :string;
    title :string;
    salary :number;
    highest_degree :Education;

    // optional parameters are having a default value
    constructor(id = 0, name='', title='', salary=0, highest_degree = new Education()) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.title = title;
        this.highest_degree = highest_degree;
    }
}
