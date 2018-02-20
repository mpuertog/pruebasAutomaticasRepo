/* This test is intended to run after ghost_post_install_test.js */

describe('Ghost Tests - 2', function () {

    //Check if environment it's ok
    it('.should() - confirm ghost is online', function () {
      cy.visit('http://localhost:2368')
      cy.title().should('include', 'Test Blog')

    })

    //Login admin account
    it('.should() - login admin account', function(){
        cy.visit('http://localhost:2368/ghost')
        cy.get('#ember448').type('my@email.com')
        cy.get('#ember450').type('pwd12345678')
        cy.get('#ember460 > span').click()
        cy.title().should('include', 'Content')
    })

    //Logout admin account
    it('.should() - logout admin account', function(){
        cy.visit('http://localhost:2368/ghost')
        cy.get('#ember448').type('my@email.com')
        cy.get('#ember450').type('pwd12345678')
        cy.get('#ember460 > span').click()
        cy.title().should('include', 'Content')
        cy.get('#ember861 > svg').click()
        cy.get('#ember1100').click()
        cy.title().should('include', 'Sign In')
    })

    
    //Post an entry in a blog
    it('.should() - logout admin account', function(){
        cy.visit('http://localhost:2368/ghost')
        cy.get('#ember448').type('my@email.com')
        cy.get('#ember450').type('pwd12345678')
        cy.get('#ember460 > span').click()
        cy.title().should('include', 'Content')
        cy.get('#ember876').click()
        cy.get('#ember1118').type('Test post Title')
        cy.get('.CodeMirror-line').type('Content for test post')
    })
    


})
 
