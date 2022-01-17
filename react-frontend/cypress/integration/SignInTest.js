describe('SignIn Test', () => {
    it('.get()', () => {
        cy.visit('http://localhost:3000/SignIn')
      cy.get('input[name="usrname"]')
      .type('test1')
      .should('have.value', 'test1')

      cy.get('input[name="password"]')
      .type('123')
      .should('have.value', '123')

      
      cy.get('button[name="btn"]')
      .click()

      cy.url().should("include",'/')
    })
})
