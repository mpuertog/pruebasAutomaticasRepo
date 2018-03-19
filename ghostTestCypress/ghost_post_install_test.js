/* This test is intended to run on a CLEAN local install of Ghost */

describe('Ghost Tests', function () {

    //Check if environment it's ok
    it('.should() - confirm ghost is online', function () {
      cy.visit('http://localhost:2368')
      cy.title().should('include', 'Ghost')

    })


    //Check access to setup section
    it('.should() - access the setup', function(){
        cy.visit('http://localhost:2368/ghost')
        cy.title().should('include', 'Setup')
    })

    
    //Check creation of admin account
    it('.should() - create admin account', function(){
        cy.visit('http://localhost:2368/ghost')
        cy.get('#ember474 > span').click()
        cy.get('#ember627').type('Test Blog')
        cy.get('#ember633').type('John Doe')
        cy.get('#ember636').type('my@email.com')
        cy.get('#ember639').type('pwd12345678')
        cy.get('#ember643 > span').click()
    })
    

    //Login admin account
    it('.should() - login admin account', function(){
        cy.visit('http://localhost:2368/ghost')
        cy.get('#ember448').type('my@email.com')
        cy.get('#ember450').type('pwd12345678')
        cy.get('#ember460 > span').click()
        cy.title().should('include', 'Content')
    })


})
 
