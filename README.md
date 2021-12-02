# Proyecto de Lenguajes de Programacion II y Diseño de Bases de Datos 1
* [General info](#general-info)
* [Instructions](#instructions)
* [Code progress](#code-progress)
* [Inspiration](#inspiration)
* [Version](#version)
* [Sources](#sources)

## General info
This project was done for the class of Lenguajes de Programacion II & Diseño de Bases de Datos I, it's still a work in progress and is my first time using Java Swing so be prepared for any spaghetti code you might find.
* By: Jesus Alejandro Jimenez Hernandez
* Number: 338906
* University: Universidad Autonoma de Chihuahua
* Date: Wednesday 1st December 2021
* Done using Netbeans and JDK8 
* Database implemented using the Dcoker Image Oracle Database 12C Express Edition

# Instructions
In order for you to run the build its goind to be necesary that you configure a few things.
First of all, this project was done using Netbeans
## Netbeans
### Windows
You can download Netbeans in the following link: https://netbeans.apache.org/download/index.html

### Linux
I don't really like using Snaps in Linux but it was the easier way to get it running in Manjaro.
#### Manjaro
Check that Manjaro is up to date.
```
$ sudo pacman -Syu
```
Download the snapd package.
```
$ sudo pacman -S snapd
```
Enable the snapd.socket.
```
$ sudo systemctl enable --now snapd.socket
```
Create a softlink to `/var/lib/snapd/snap`.
```
$ sudo ln -s /var/lib/snapd/snap /snap
```
Install the Netbeans snap.
```
$ sudo snap install netbeans --classic
```

#### Other Distributions
Visit the following link: https://snapcraft.io/netbeans

## Docker
In my case I used docker to create the image for the Oracle Database, this is way better for maximum compatibility between distributions. 

### Windows
Download Docker Desktop in the following link: https://hub.docker.com/editions/community/docker-ce-desktop-windows/
### Manjaro
Check that Manjaro is up to date.
```
$ sudo pacman -Syu
```
Download the Docker package.
```
$ sudo pacman -S docker
```
In case you want to run it everytime your computer turns on, configure the sevice with the following commands.
```
$ sudo systemctl start docker.service
$ sudo systemctl enable docker.service
```

You can also configure Docker so it runs without the need of typing `sudo` every time (needs to reboot after command is typed)

```
$ sudo usermod -aG docker $USER
```
For more details and information visit: https://linuxconfig.org/manjaro-linux-docker-installation
### Other Distribution
You can find all the information for installation in: https://docs.docker.com/engine/install/


## Oracle Database 12C Docker Image
You can subscribe to this container in the following link: https://hub.docker.com/_/oracle-database-enterprise-edition

Documentation on the configuration of the container is provided once you subscribe to the service.

## Oracle Database Installation Natively
You can also download Oracle natively into you computer, I find it harder to make it work under Manjaro, but if you are a Windows User there shouldn't be any problem in the configuration. You can download it in the following link: https://www.oracle.com/database/technologies/oracle-database-software-downloads.html

## Oracle Database Driver
Netbeans provides you with a link to download the driver once you try to connect to the database for the first time. The version of the driver depends on the on the JDK version you are running. Since we are using JDK8 (version my project was created with), download the OJDBC7.jar driver in the following link: https://www.oracle.com/database/technologies/jdbc-drivers-12c-downloads.html


# Code progress
The project right now includes a login and a dashboard, I'm going to detail what each part is missing and needs fixing from what I've found.
## Login
The login form it's the most complete part of the code, but it's still missing mayor components.
Missing Features
* Admin login to it's own dashboard
* Login logs (at what time did a user log, what did the user did, did the user leaved an inclomplete reservation, at what time was the reservation done, and so on)
* Overhall to the register form, while its functional, I still don't like that the form shows so much information at the time to the user, it feels overwhelming.
* Title bar that lets you move the window
* Maximize window (this also includes the scalling of the components)
* Limit the size of the image you can set on your profile

## Dashboard
The dashboard it's the most incomplete part of the code, you can do reservations, search them and cancel them at the moment.
Missing Features
* Different menu and submenu options depending if you logged in as a guest user or with your profile
* Modify the reservation
* Autofill for the reservation information form if you have an account
* See if a reservation is active or not.
* See if the reservation ahs already passed.
* Ability for the admin to see if the car was picked up or not.
* Ability to see the reservation when you search for it and see all the data
* Ability for an account user to see all the reservation he/she has.
* Ability for the account user and guest user to extend an existing reservation (when the car has already been picked up)
* Give the account user a discount for their first reservation
* Ability to change the information of the account
* Ability to see your account details
* Ability for the admin to change the roaster of cars and its cost
* Ability for the admin to change the optionals, packages and its cost
* Ability for an account usser to delete their account
* Ability for the admin to see charts that display the sales
* Ability for the admin to see the inventory of the car fleed at the moment
* Ability for the admin to set the locations where cars can be rented
* Ability for the admin to set discounts and change the amount
* Custom emails that send the details of your reservation
* Custom emails that send periodicly offers
* Custom notifications in the program that notify you of a reservation, offer, etc
* There's probably even more additions I can do, but at he moment this is what I can think of.

# Inspiration
The project borrows GUI designs with self-implemented code in both the interface and logistic deparment. 
The GUI was done with GUI assests from Ra Ven.
You can find a link to both his YouTube Channel (including to the specific videos thet implemented the code) and to his GitHub repository that includes all his different projects in #Sources.

# Version
This project has already received six revisions before uploading it to GitHub.
At this moment the project has already been due to each class and since its the first time its being uploaded, I'm going to call it Version 1.0.
Updates to this code are goind to be done at a lower rate since I'm on winter vacations. Still, I'm not going to leave this project undone, you can check in #Code-Progress to see more information about this project.

# Sources
## GitHub Repository of Dj-Raven
* https://github.com/DJ-Raven

## YouTube Channel of Ra Ven
* https://www.youtube.com/c/HelloWorld-Raven/featured

## YouTube Videos that show the process of the GUI designs

### Java Swing UI Design - Login Form
* Part 1: https://www.youtube.com/watch?v=7Rc9JaflteE
* Part 2: https://www.youtube.com/watch?v=Mkz2jKi7dCA&t=22s
* Part 3: https://www.youtube.com/watch?v=KXcCdhm8s0E&t=768s

### Java Swing UI Design - School Management Dashboard
* Part 1: https://www.youtube.com/watch?v=D-LsTp4f4vA
* Part 2: https://www.youtube.com/watch?v=3GvYtpzA18E&t=27s
* Part 3: https://www.youtube.com/watch?v=e3euinaieWs
* Part 4: https://www.youtube.com/watch?v=iT806qYCoHI
* Part 5: https://www.youtube.com/watch?v=ClRFuokVYDg

### Java Swing UI Design - Login And Register
* Part 1: https://www.youtube.com/watch?v=ZUGkQHtLS4U&t=1s
* Part 2: https://www.youtube.com/watch?v=1T-SIhTh2-w&t=874s
* Part 3: https://www.youtube.com/watch?v=neIb4UYuBKc&t=1275s
* Part 4: https://www.youtube.com/watch?v=ov6sEHmspSc&t=29s

### Java Swing - Custom Material Combobox
* https://www.youtube.com/watch?v=Lz47kWa-ORQ&t=3s

### Java Swing - Date Chooser
* https://www.youtube.com/watch?v=8x_t8euwCGM

### Java Swing - Custom Material TextField and PasswordField
* https://www.youtube.com/watch?v=O-W0sB02GS4&t=27s

### Java Swing UI Design - Pricing Template
* Part 1: https://www.youtube.com/watch?v=B8TW7wNCH4U&t=6s
* Part 2: https://www.youtube.com/watch?v=ndnTBH4kVBQ&t=15s

### Java Swing - TextField Search Animation
* Part 1: https://www.youtube.com/watch?v=vKNFadqWtD8&t=120s
* Part 2: https://www.youtube.com/watch?v=bfn56kAsq4I&t=30s
