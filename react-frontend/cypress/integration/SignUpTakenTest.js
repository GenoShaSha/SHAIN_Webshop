describe('Register Test', () => {
    it('.get()', () => {
        cy.visit('http://localhost:3000/SignUp')
      cy.get('input[name="usrname"]')
      .type('admin1')

      cy.get('input[name="email"]')
      .type('admin1@gmail.com')


      cy.get('input[name="password"]')
      .type('admin1')

      
      cy.get('button[name="btn"]')
      .click()

      cy.url().should("include",'/SignIn')
    })
})
