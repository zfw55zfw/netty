namespace java com.show.thrift

typedef i32 int
typedef string String
typedef bool Boolean

struct Student{
  1: optional String name,
  2: optional int age,
  3: optional Boolean married
}

service StudentService{
    void saveStudent(1: required Student student),
    Student getStudent(1: required String name),
}