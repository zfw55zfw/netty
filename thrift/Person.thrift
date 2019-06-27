namespace java com.show.thrift

typedef i32 int
typedef string String
typedef bool Boolean

struct Person{
  1: optional String name,
  2: optional int age,
  3: optional Boolean married
}

service PersonService{
    void savePerson(1: required Person Person),
    Person getPerson(1: required String name),
}