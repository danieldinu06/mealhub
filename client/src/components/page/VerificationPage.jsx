import "./Verification.css";

export default function VerificationPage() {
    return (
        <div className="verificationPage">
            <div className={"verifyPanel"}>
                <p>
                    Check your email in order to verify this account.
                </p>
                <a href={"https://www.gmail.com"} target={"_blank"} rel={"noreferrer"} e>
                    Go to email
                </a>
            </div>
        </div>
    );
}