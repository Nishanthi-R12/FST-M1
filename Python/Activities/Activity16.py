"""Create a car class with the following details:

Properties: manufacturer, model, make, transmission, color
Methods: accelerate(), stop()
accelerate() should print "{Manufacturer} {Model} is moving"
stop() should print "{Manufacturer} {Model} has stopped"
Using this car class, create 3 different car objects."""

class Car:
    'This class represents a car'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " " + "has started moving")
    
    def stop(self):
        print(self.manufacturer + " " + self.model + " " + "has stopped moving")
    
    car1 = Car("Honda", "Jazz", "2016", "Manual", "Grey")
    car2 = Car("Hyndai", "i20", "2017", "Automatic", "White")
    car3 = Car("Toyota", "Innova", "2018", "Automatic", "Black")

    car1.accelerate()
    car2.stop()
